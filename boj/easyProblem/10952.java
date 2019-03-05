"
[문제요약]
여러개의 테스트케이스의 마지막엔 0 0이 입력으로 들어옴.

[해결방법]
루프 중간에 0 0 이 들어오면 멈추는 while 루프를 사용했음.

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
		while (true) {
			a = scin.nextInt();
			b = scin.nextInt();
			if (a==0 && b==0)
				break;
			System.out.println(a+b);
		}
		scin.close();
	}
}
