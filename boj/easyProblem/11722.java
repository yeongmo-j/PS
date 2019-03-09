"
[문제요약]
감소하는  가장 긴 부분수열의 길이 찾기.
같으면 안되고 순감소 해야 한다.

[해결방법]
dp bottom up으로 풀었다.
일단 d[i]를 정의. d[i] = A[i]가 마지막 부분수열에 포함될 때, 그 최대 길이
결국, d[i] = if(A[i]<A[j), max(d[j]+1) (j<i인 모든 수)
주의해야 할 점!
부분수열이 크기는 최소 하나이다!! 그러므로 d[i]=1로 초기화 한 후에 루프 돌릴 것.

Time complexity : O(N^2)
Space complexity : O(N);

[추가]
11053과 똑같아

하지만 , 증가하는 수열의 문제와 진짜 똑같이 풀 수 있는데,
그 방법은 입력 수열을 뒤집는 것!
(증가하는 부분수열을 뒤집으면 감소하는 수열이 된다 )
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int[] A = new int[n+1];
		int i, j;
		for (i=1 ; i<=n ; i++)
			A[i] = scin.nextInt();
		int[] d = new int[n+1];
		//d[i]는 A[i]가 마지막 부분수열 일 때에, 그 부분수열의 최대 합
		for (i=1 ; i<=n ; i++) {
			d[i] = 1;
			for (j=1 ; j<=i-1 ; j++) {
				if (A[i]<A[j]) {
					d[i] = Math.max(d[i], d[j]+1);
				}
			}
		}

		int max = 0;
		for (int x : d){
			max = Math.max(max, x);
		}
		System.out.println(max);
		scin.close();
	}
}
