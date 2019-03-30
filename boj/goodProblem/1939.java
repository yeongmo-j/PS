"
[문제요약]
N개의 섬이 있고 M개의 다리가 있으며, 각 다리에는 최대 중량 제한이 있다.
공장2개가 있을 떄,(섬의 번호)
각 공장을 오고갈 수 있는 최대 무게를 구하시오.


[해결방법]
중량 제한 중에 최소인걸 찾는 문제가 아님!!
중량 제한에 걸려도
돌아돌아 가서 목적지 공장에 갈수만 있다면 가능 한것임 -> 가중치가 특정 값 이상인 경로 찾기

그런데, 최대 무게를 구해야 한다? -> 만약 물자의 무게가 주어진다면, 그걸 수송 가능한
경로를 yes / no로 정답인지 확인 할 수 있다 -> 이분탐색.

left = 최소가중치 = 1로 시작
right = 가중치 중 최대 로 시작
m = (left+right)/2 해서
yes면 left + m+1 , m의 값저장한뒤에 끝나고 나서 그 저장한 값중에 최대값이 정답
no면 right = m-1

그렇다면 이제 문제는, yes/no를 어떻게 구하느냐?
경로찾기 -> dfs or bfs
난 bfs로 풀었음
그래서 한 공장에서 시작해서 다음 공장 도달만 하면 true, bfs 끝ㄴ날때까지 도달못하면 false
큐에 넣을 때, edge만으로 결정하면 안되고,
가중치가 m을 넘어야만!(최대 중량 제한에 안걸려야먄) 큐에 넣을 수 있다.

Time complexity : O(N * lg(최대가중치))
Space complexity : O(N)

[추가]

이분탐색 : 신경써줘야 할 것이 많다
Yes / no로 나눠지는지?
어떤 경계가 no일때, 그 이상으로는 다 no이다 : 최대값 찾기
어떤 경계가 no일때, 그 이하로는 다 no이다 : 최소값 찾기
검증하는 방법은? <- 이걸 구현하는건 어렵지 않다.
이게 이분탐색으로 풀수 있냐 없냐까지 생각 도달하는게 더 중요한거 같아 보임

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static LinkedList<int[]>[] edge;
	static int N;
	static int M;
	static int from;
	static int to;

	static boolean check(int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		visited[from] = true;
		queue.add(from);
		while (!queue.isEmpty()) {
			int now = queue.remove();
			for (int[] array : edge[now]) {
				if (visited[array[0]] == false && array[1]>=m) {
					if (array[0] == to)
						return true;
					visited[array[0]] = true;
					queue.add(array[0]);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		N = Integer.valueOf(in[0]);
		edge = (LinkedList<int[]>[]) new LinkedList[N+1];
		M= Integer.valueOf(in[1]);
		int i;
		for (i=1 ; i<=N ; i++) {
			edge[i] = new LinkedList<int[]>();
		}
		int left = 1, right = Integer.MIN_VALUE;
		for (i=0 ; i<M ; i++) {
			in = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			int c = Integer.parseInt(in[2]);
			right = Integer.max(c, right);
			int[] temp2 = new int[2];
			temp2[0] = b;
			temp2[1] = c;
			edge[a].add(temp2);
			temp2 = new int[2];
			temp2[0] = a;
			temp2[1] = c;
			edge[b].add(temp2);
		}
		in = br.readLine().split(" ");
		from = Integer.parseInt(in[0]);
		to = Integer.parseInt(in[1]);
		int answer = 1;
		while (left<=right) {
			int m = (left+right)/2;
			if (check(m)) {
				answer = Integer.max(answer, m);
				left = m+1;
			} else
				right = m-1;
		}
		System.out.println(answer);
	}
}
