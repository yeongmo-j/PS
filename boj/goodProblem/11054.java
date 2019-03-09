"
[문제요약]
S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN
를 만족하는 부분배열의 제일 긴 길이 찾기

[해결방법]
dp bottom up으로 풀었다.
부분배열의 모양을 살펴보면 ,
Sk앞까지는 증가하는 배열이고 ,Sk뒤로는 감소하는 배열이다.
즉ㅁ Sk를 기준으로 증가하는 부분배열,
뒤로 감소하는 부분배열을 찾아서
그 두개를 더한다음에 1을 빼주면 저런 모양의 부분배열이 탄생한다.
d[i] = A[i]가 포함된 부분배열 중(앞에서부터 시작) 순증가하는 부분배열의 최대 길이
f[i] = A[i]로 시작되는 부분배열 중(맨뒤까지) 순감소하는 부분배열의 최대 길이
정답 : d[i] + f[i] -1 중 최대값

Time complexity : O(N^2)
Space complexity : O(N);

[추가]
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
				if (A[i]>A[j]) {
					d[i] = Math.max(d[i], d[j]+1);
				}
			}
		}
		int[] f = new int[n+1];
		for (i=n ; i>=1 ; i--) {
			f[i] = 1;
			for (j=n ; j>=i+1 ; j--) {
				if (A[i]>A[j]) {
					f[i] = Math.max(f[i], f[j]+1);
				}
			}
		}

		int max = 0;
		for (i=1 ; i<=n ; i++){
			max = Math.max(max, d[i]+f[i]-1);
		}
		System.out.println(max);
		scin.close();
	}
}
