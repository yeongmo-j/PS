"
[문제요약]
1부터 N까지 합 구하기

[해결방법]
수식 이용

Time complexity : O(1)
Space complexity : O(1);

[추가]
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		System.out.println(n*(n+1)/2);

		scin.close();
	}
}
