"
[문제요약]
N들어오면 1부터 N까지 찍기

[해결방법]

Time complexity : O(N)
Space complexity : O(1);

[추가]
"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int i=0;
		while (++i<=N) {
			System.out.println(i);
		}
		scin.close();
	}
}
