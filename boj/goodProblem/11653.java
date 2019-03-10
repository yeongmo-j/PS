"
[문제요약]
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오


[해결방법]


Time complexity : O(N) : 소인수분해 아무리많이해도 2로 계속 나눈거보단 횟수 적음 : while루프가
lgN보다 적게 돌아감. 그러나 소수일 경우 그 위에 루프가 N번 돌아가므로, O(N)이다.
Space complexity : O(1)

[추가]
소인수 분해 방법 알아두기.


"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		for (int i=2 ; i*i<=N ; i++) {
			while (N%i==0) {
				System.out.println(i);
				N/=i;
			}
		}
		if (N>1) {
			System.out.println(N);
		}

		scin.close();
	}
}
