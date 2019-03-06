"
[문제요약]
10 20 30 40이 들어오면
1020 + 3040 을 구해서 4060을 출력.

[해결방법]
Long.parseLong(A+B)+Long.parseLong(A+B)
로 구했음.

Time complexity : O(1)
Space complexity : O(1);

[추가]
숫자 2개를 붙여버리면 범위가 매우 커진다.
Long으로 사용해야 함!!

"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		String A = scin.next();
		String B = scin.next();
		String C = scin.next();
		String D = scin.next();

		System.out.println(Long.parseLong(A+B)+Long.parseLong(C+D));

		scin.close();
	}
}
