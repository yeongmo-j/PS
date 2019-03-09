"
[문제요약]
증가하는 가장 긴 부분수열의 길이 찾기.
같으면 안되고 순증가 해야 한다.

[해결방법]
dp bottom up으로 풀었다.
일단 d[i]를 정의. d[i] = A[i]가 마지막 부분수열에 포함될 때, 그 최대 길이
결국, d[i] = if(A[i]>A[j), max(d[j]+1) (j<i인 모든 수)
주의해야 할 점!
부분수열이 크기는 최소 하나이다!! 그러므로 d[i]=1로 초기화 한 후에 루프 돌릴 것.

Time complexity : O(N^2)
Space complexity : O(N);

[추가]
d[i]=1로 초기화 해주는게 중요함!!
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
		//d[i]는 A[i]가 마지막 부분 수열 일 때, 이를 포함해서 증가하는 부분 수열 중 제일 긴 수열의 길이
		d[1]= 1;
		for (i=2 ; i<=n ; i++) {
			d[i] = 1;
			for (j=1 ; j<=i-1 ; j++) {
				if (A[j]<A[i]) {
					d[i] = Math.max(d[j]+1, d[i]);
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
