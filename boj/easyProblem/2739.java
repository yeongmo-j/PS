"
[문제요약]
구구단

[해결방법]


Time complexity : O(1)
Space complexity : O(1);

[추가]
"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		for (int i=1 ; i<=9 ; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
		scin.close();
	}
}
