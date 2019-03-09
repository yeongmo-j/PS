"
[문제요약]
증가하는 가장 긴 부분수열의 총 합 찾기 .
같으면 안되고 순증가 해야 한다.

[해결방법]
dp bottom up으로 풀었다. 최대 길이 찾는것과 똑같음
일단 d[i]를 정의. d[i] = A[i]가 마지막 부분수열에 포함될 때, 그 최대 합
결국, d[i] = if(A[i]>A[j), max(d[j]+A[i]) (j<i인 모든 수)
주의해야 할 점!
부분수열이 크기는 최소 하나이다!! 그러므로 d[i]=A[i]로 초기화 한 후에 루프 돌릴 것.

Time complexity : O(N^2)
Space complexity : O(N);

[추가]
11053과 똑같음
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
			d[i] = A[i];
			for (j=1 ; j<=i-1 ; j++) {
				if (A[i]>A[j]) {
					d[i] = Math.max(d[i], d[j]+A[i]);
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
