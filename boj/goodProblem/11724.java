"
[문제요약]
그래프 들어오고
연결 요소(Connected Component)가 몇 개인지 확인

[해결방법]
일단 1부터 N까지(간선의 개수) 루프를 돌리는데,
루프 내용은 i번째 간선을 아직 방문안했으면, 그 i를 시작으로 하는 DFS나 BFS를 돌린다.
그리고 카운트를 추가한다.
이렇게 되면 i와 연결된 곳은 다 방문한다.
이걸 1부터 N까지 돌리면 된다.

Time complexity : O(V+E) (DFS와 같음 )
Space complexity : O(E) (LinkedList)

[추가]

밑에 코드에서 BFS나 reset은 무시할것. 전에 사용했던 정답을 재사용한것임.

"

import java.util.*;

class Graph {
	boolean[] visited;
	LinkedList<Integer>[] edge;

	void resetVisited(int N) {
		visited = new boolean[N+1];
	}

	Graph(int N, LinkedList<Integer>[] edge){
		visited = new boolean[N+1];
		this.edge = edge;
	}

	void DFS(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		for (int next : edge[v]) {
			if (visited[next]==false) {
				DFS(next);
			}
		}
	}

	int connectedComponent() {
		int count=0;
		for (int i=1 ; i<edge.length ; i++) {
			if (visited[i]==false) {
				count++;
				DFS(i);
			}
		}
		return count;
	}


	void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = true;

		while(!queue.isEmpty()) {
			int now = queue.remove();
			System.out.print(now + " ");
			for (int next : edge[now]) {
				if (visited[next]==false) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

}

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();
		int M = scin.nextInt();

		LinkedList<Integer>[] edge = (LinkedList<Integer>[]) new LinkedList[N+1];

		for (int i=1 ; i<=N ; i++) {
			edge[i] = new LinkedList<Integer>();
		}

		int a, b;
		while (--M>=0) {
			a = scin.nextInt();
			b = scin.nextInt();
			edge[a].add(b);
			edge[b].add(a);
		}

		for (int i=1 ; i<=N ; i++) {
			Collections.sort(edge[i]);
		}

		Graph graph = new Graph(N,edge);

		System.out.println(graph.connectedComponent());

		scin.close();
	}
}
