"
[문제요약]
n개의 포도주 잔을 마시는데, 각 포도주의 양이 배열로 들어온다.
이때 3개의 포도주 잔을 연속으로 마실 수는 없을 때,
가장 많은 양의 포도주를 마셔서 그 값을 출력해라.


[해결방법]
@@@@@@@@@@@@@@@@@@@@@@
dp의 정의 : d[i][j] : i번째 잔이 j잔 연속으로 마신 잔일 때의 최대 마신 양
포도주 양을 A[i]라 할 떄
d[i][0] = max{d[n-1][0~2]} 0번 연속이므로, 자기는 안마신거임. 그러므로 앞에서 뭐였던간에 상관 없음
d[i][1] = d[n-1][0] + A[i] : 1번 연속이므로, 앞에선 안마시고 이번에는 마심
d[i][2] = d[n-1][1] + A[i] : 2번 연속이므로 ,앞에선 마시고 이번에도 마심

이렇게 다 구해서
d[n][0~2]중 최대값 구해주면 된다.


Time complexity : O(N)
Space complexity : O(1);

[추가]
@@@@@@@@@@@@@@@@@@@@@@@@
이차원 dp 말고, 일차원 dp로 살펴보자
d[i]는 i번째 포도주까지의 최대 양으로 정의 한다면,
0번째 연속일 때, 안마신거므로 d[i-1]
한번째 연속일 때, 앞에서 안마시고 이번에 마시는거이므로, d[i-2] + A[i]
두번째 연속일 때, 앞앞에서 안마시고, 앞에서 마시고 이번에 마시는거이므로, d[i-3]+A[i-1]+A[i]

이 생각이 너무 중요함@@@@@@@@@@@@@@@@@@@@@@@@@


"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int[] A = new int[n+1];
		int i;
		for (i=1 ; i<=n ; i++)
			A[i] = scin.nextInt();
		int[][] d = new int[i+1][3];
		d[1][0] = 0;
		d[1][1] = A[1];
		d[1][2] = 0;
		for (i=2 ; i<=n ; i++) {
			d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] = d[i-1][0] + A[i];
			d[i][2] = d[i-1][1] + A[i];
		}

		System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));
		scin.close();
	}
}
