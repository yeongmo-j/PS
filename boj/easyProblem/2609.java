"
[문제요약]
최대공약수 최소공배수 구하는 문제


[해결방법]


Time complexity : O(?)
Space complexity : O(1);

[추가]
백준 수학 1 확인
"
import java.util.Scanner;

public class Main {

	static int GCD(int a, int b) {
		if (b==0)
			return a;
		else
			return GCD(b, a%b);
	}


	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int a = scin.nextInt();
		int b= scin.nextInt();
		int gcd = GCD(a,b);
		System.out.println(gcd);
		System.out.println(a*b/gcd);
		scin.close();
	}
}
