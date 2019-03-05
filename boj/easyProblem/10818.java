"
[문제요약]
최대값과 최소값 구하기

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
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int N = scin.nextInt();
		int temp;
		while (--N>=0) {
			temp = scin.nextInt();
			if (temp<min)
				min = temp;
			if (temp>max)
				max = temp;
		}
		System.out.println(min + " " + max);
		scin.close();
	}
}
