"
[문제요약]
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

즉,
(A,B,C)각각 원소 사이에는 edge가 없고,  (D,E,F)각각 원소 사이에도 edge가 없고
첫번째 집합과 두번째 집합 사이에면 edge가 존재 할 때, 이를 bipartite graph라고 한다.



[해결방법]
방문 했는지 안했는지를 판별 할 때, 추가 정보를 하나 더 저장한다.
첫번째 그룹에 속하냐, 두번째 그룹에 속하냐 를 저장한다.
따라서, 방문 안한거면 0, 첫번째면 1, 두번째면 2 로 저장을 한다.

visited[i]를 저장 할 때, 재귀를 시작하기 전(스택에 넣기 전)에 이 정보를 저장한다.

그리고 그래프가 연결 그래프가 아닐 수도 있으므로, 연결 요소 찾는 것처럼, 각 정점에 대해 반복 해줘야 한다.

마지막에, 각 edge에 대해, 양쪽 정점의 visited값이 서로 다른지(합해서 3인지) 판별 해주면 됨.

Time complexity : O(V+E) (DFS와 같음 )
Space complexity : O(V+E) (LinkedList)

[추가]

연결그래프가 아닐 수 있음을 주의!!!

그리고 색깔 정할 때, ㅁ?ㅁ:ㅁ로 판별 하지 말고, 3-ㅁ로 해주면 됨 (어차피 합하면 3이므로)

"

import java.util.*;

class Graph {
	int[] visited;

	LinkedList<Integer>[] edge;


	Graph(int N, LinkedList<Integer>[] edge){
		visited = new int[N+1];
		this.edge = edge;
	}

	boolean biparitite() {

		for(int i=1 ; i<visited.length ; i++) {
			if (visited[i]==0) {
				visited[i] = 1;
				DFS(i);
			}
		}

		for (int i=1 ; i<edge.length ; i++) {
			for (int to : edge[i]) {
				if (visited[i] + visited[to] != 3)
					return false;
			}
		}
		return true;
	}

	void DFS(int v) {
		for (int next : edge[v]) {
			if (visited[next]==0) {
				visited[next] = visited[v]==1 ? 2 : 1;
				DFS(next);
			}
		}
	}
}

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int K = scin.nextInt();

		while (--K>=0) {
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

			Graph graph = new Graph(N,edge);

			System.out.println(graph.biparitite()==true ? "YES" : "NO");

		}
		scin.close();
	}
}
