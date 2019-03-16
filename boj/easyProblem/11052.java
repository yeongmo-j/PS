"
[문제요약]
카드를 1개씩 묶어서 팔고
2개씩 묶어서 팔고
N개씩 묶어서 파는데

이중에서 N개의 카드를 살 때, 최대로 비싸게 사는법


[해결방법]
DP로 풀었다
maximum[i] = i개의 카드를 살 때 최대로 지불 할 수 있는 값

Time complexity : O(N^2)
Space complexity : O(N)

[추가]


"
import java.util.*;

public class Main {


	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();
		int[] price= new int[N+1];
		int[] maximum = new int[N+1];
		//maximum[i]는 i개의 카드를 사는데 드는 최고 비용
		int i, j;

		for (i=1 ; i<=N ; i++)
			price[i] = scin.nextInt();

		for (i=1 ; i<=N ; i++) {
			for (j=1 ; j<=i ; j++) {
				maximum[i] = Integer.max(maximum[i], price[j]+maximum[i-j]);
			}
		}
		System.out.println(maximum[N]);


		scin.close();
	}
}
