"
[문제요약]
1~N까지의 순열 하나가 입력으로 들어온다
이 때, 배열을 만들 수가 있는데, arr[i]는 i번째 순열의 숫자이다.
즉
i       1 2 3 4 5 6 7 8
arr[i]  3 2 7 8 1 4 5 6
으로 만들 수 있는데, 이는 N개의 정점을 가진 그래프 중 i번째 정점에서 arr[i]번쨰 edge가 존재한다는
의미로 만들 수 있다.

이렇게 그래프를 만들었을 때,
사이클이 몇개 존재하는가?


[해결방법]
자기한테 들어오는것도 하나고, 나가는것도 하나이므로 굳이 리스트 만들 필요 없이
꼬리에 꼬리를 물며 연결요소 찾을 수 있다.

그래서 그냥 1부터 N까지 루프 돌리며, 방문 안한거면 1을 추가하고 거기부터 꼬리물기 시작한다.

Time complexity : O(N) N개의 edge
Space complexity : O(N)

[추가]

"

import java.util.*;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int T = scin.nextInt();

		while (--T>=0) {

			int N = scin.nextInt();
			int[] arr = new int[N+1];
			boolean[] visited = new boolean[N+1];
			int count=0;
			for (int i=1 ; i<=N ; i++) {
				arr[i] = scin.nextInt();
			}
			for (int i=1 ; i<=N ; i++) {
				if (visited[i] == false) {
					visited[i] = true;
					count++;
					int now = i;
					while (true) {
						int next = arr[now];
						if (visited[next] ==false) {
							visited[next] = true;
							now = next;
						}
						else
							break;
					}
				}
			}

			System.out.println(count);

		}
		scin.close();
	}
}
