"
[문제요약]
테스트케이스 수가 주어지지 않은 입력 더하기 문제.

[해결방법]
while(scin.hasNext())
로 루프를 돌렸다.

Time complexity : O(N)
Space complexity : O(1);

[추가]

"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int a, b;
		while (scin.hasNext()) {
			a = scin.nextInt();
			b = scin.nextInt();
			System.out.println(a+b);
		}
		scin.close();
	}
}
