"
[문제요약]
0~N까지의 숫자 k개로 N을 만드는 경우의 수


[해결방법]
dp로 해결
d[k][n] 을 0~n까지의 숫자 k개로 n을 만드는 경우의 수라고 정의하면,
ㅁ+ㅁ+ㅁ+....+ㅁ = n이라고 했을 떄,
따로 ㅇ이라는 숫자를 빼면
ㅁ+ㅁ+ㅁ+ㅁ+...+ㅁ+ㅇ=n이 된다.
이는 즉, d[k-1][n-ㅇ]가 되고,
n-ㅇ의 범위는 0부터 N까지가 된다.

이를 식으로 세우면
d[k][n] = sigma d[k-1][n-l] (0<=l<=n)
이 된다.

이를 구해주면 되는데,
일단
for (i=1 ; i<=k ; i++)
로 k의 범위를 세워주고
for (j=0 ; j<=n ; j++)
로 n의 범위를 세워준다.
그다음에 d[i][j]를 계산해주면 되는데,
뒤에오는 인덱스의 범위는 0보다 커야 한다.
그러므로
for (l=0 ; j-l>=0 ; l++)로 범위를 세워 준다.
d[0][0]=1;
		for (i=1 ; i<=K ; i++) {
			for (j=0 ; j<=N ; j++) {
				for (k=0 ; j-k>=0 ; k++) {
					d[i][j]+=d[i-1][j-k];
					d[i][j]%=1000000000;
				}
			}
		}
가 된다.
복잡도는 K*N*N = KN^2이 된다.


Time complexity : O(KN^2)
Space complexity : O(KN);

[추가]
어렵게 풀었음.
@@공간 줄이기
d[i][j]를 구할 때 d[i-1]만 필요한ㄴ 것을 알 수 있다.
이를 통해 d[n]크기의 배열 2개를 가지고, 번갈아가면서 채울 수 있다.
space complexity 가 O(N)이 됨.
d[i]가 d[i%2]로 변하면 됨!!! 그리고 d[(i-1)%2]로 전에껄 구할 수 있다!
아주 좋은 생각인 것 같음.

"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int K = scin.nextInt();
		long[][] d = new long[K+1][N+1];
		int i, j, k;
		d[0][0]=1;
		for (i=1 ; i<=K ; i++) {
			for (j=0 ; j<=N ; j++) {
				for (k=0 ; j-k>=0 ; k++) {
					d[i][j]+=d[i-1][j-k];
					d[i][j]%=1000000000;
				}
			}
		}
		System.out.println(d[K][N]);

		scin.close();
	}
}
