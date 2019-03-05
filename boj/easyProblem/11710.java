"
[문제요약]
숫자가 들어오고
각 자리 숫자 합 구하기

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
		int result=0;
		String str = scin.next();
		for (char c : str.toCharArray()) {
			result += (int)(c-'0');
		}
		System.out.println(result);
		scin.close();
	}
}
