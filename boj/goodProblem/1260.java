"
[문제요약]
DFS, BFS 구현하기
대신 방문할 노드가 여러개면, 숫자 작은거부터 먼저 방문

[해결방법]

Time complexity : O(V+E)
Space complexity : O(E)

[추가]

DFS는 방문하자마자 visited를 바꿔줘야 하고,
@@BFS는 방문하기 전에, 큐에 넣을 때 visited를 바꿔줘야 함!!
안그러면 큐에 중복으로 들어갈 수가 있음!!!!!@@@@@@2

그리고 LinkedList<Integer>형의 배열을 만들 때
LinkedList<Integer>[] edge = (LinkedList<Integer>[]) new LinkedList[N+1];
이렇게 형변환을 이용해서 해주면 된다

아주 좋은문제!!!@@!@!@!@

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
		System.out.print(v + " ");
		visited[v] = true;
		for (int next : edge[v]) {
			if (visited[next]==false) {
				DFS(next);
			}
		}
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
		int V = scin.nextInt();

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

		graph.DFS(V);
		System.out.println();
		graph.resetVisited(N);
		graph.BFS(V);
		System.out.println();


		scin.close();
	}
}
