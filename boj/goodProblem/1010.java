"
[문제요약]
왼쪽에 구역이 N개 있고, 오른쪽에 구역이 M개 있다(N<=M)
이때, 왼쪽에서 오른쪽으로 가는 다리를 하나씩 놓을 때, (총 N개의 다리)
그 다리를 놓는 경우의 수를 구하여라.
하지만 다리가 교차할 수는 없다. 왼쪽에서 위에 있는 구역은 오른쪽에 다리로 이어진 구역보다 위에 있어야 함.

[해결방법]
DP로 해결
d[i][j] = 왼쪽에 i개, 오른쪽에 j개 있을 때의 경우의 수
일단 맨위에서부터 하나씩 고르고, i-1개중에 그 아래 있는거 고르는 경우의 수를 다 더한 것과 같다.
즉 k= 1부터 j-k>=i-1이 될 때까지
d[i][j] = sigma(d[i-1][d[j-k]])가 된다.(위에서부터 하나씩 고름)

이 때, 처음에 초기경계를 잘 세워줘야 한다
d[0][i] = 0
d[1][i] = i가 된다.


Time complexity : O(N*M^2)
Space complexity : O(N*M)

[추가]
어렵게 풀음;;

"
import java.util.*;

public class Main {


	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int T = scin.nextInt();
		while(--T>=0) {
			int N = scin.nextInt();
			int M = scin.nextInt();
			int[][] d = new int[N+1][M+1];
			//d[i][j] 는 서쪽에 i개 동쪽에 j개가 있을 때의 경우의 수
			int i, j, k;
			for (i=0 ; i<=M ; i++) {
				d[0][i] = 1;
				if(N>=1)
					d[1][i] = i;
			}
			for (i=2 ; i<=N ; i++) {
				for (j=i ; j<=M ; j++) {
					for (k=1 ; j-k>=i-1 ; k++) {
						d[i][j] += d[i-1][j-k];
					}
				}
			}
			System.out.println(d[N][M]);
		}
		scin.close();
	}
}
