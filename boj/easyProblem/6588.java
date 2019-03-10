"
[문제요약]
4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
를 증명.
정수가 들어오면 n = a + b의 형식으로 출력
a, b는 홀수인 소수임


[해결방법]
에라토스테네스의 체

Time complexity : O(NlglgN)
Space complexity : O(N)

[추가]
복잡도 생각해봐야하는데 귀찮아서 넘어감.

"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int[] prime = new int[1000001];
		int i, j;
		int n=0;
		for (i=2 ; i<=1000000 ; i++) {
			for (j=2; j*i<=1000000 ; j++) {
				prime[i*j]=1;
			}
		}
		while (true) {
			n = scin.nextInt();
			if (n==0)
				break;
			for (i=2 ; i<=1000000 ; i++) {
				if (i%2==1 && (n-i)%2==1 && prime[i]==0 && prime[n-i]==0) {
					System.out.printf("%d = %d + %d\n", n, i, n-i);
					break;
				}
			}
			if (i>1000000)
				System.out.println("Goldbach's conjecture is wrong.");
		}
		scin.close();
	}
}
