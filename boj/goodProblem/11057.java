"
[문제요약]
2234와 3678, 11119처럼 앞의 자리보다 뒤의 자리수가 같거나 같은 수 중에 n자리인 수의 개수를 구하여라

[해결방법]
dp 재귀로 사용
d[i][n] 은 i번째 자리의 수가 n인 가지수
즉 for (k=0 ; k<=n ; k++)
      d[i][n]+=d[i-1][k]
를 한 결과가 d[i][n]이다.

Time complexity : O(N)
Space complexity : O(1);

[추가]

"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int mod = 10007;
		long[][] d = new long[n+1][10];
		int i, j, k;
		for (i=0 ; i<=9 ; i++)
			d[1][i] = 1;
		for (i=2 ; i<=n ; i++) {
			for (j=0 ; j<=9 ; j++) {
				for (k=0 ; k<=j ; k++) {
					d[i][j] += d[i-1][k];
				}
				d[i][j]%=mod;
			}
		}
		long result=0;
		for (i=0 ; i<=9 ; i++)
			result+=d[n][i];
		result%=mod;

		System.out.println(result);
		scin.close();
	}
}
