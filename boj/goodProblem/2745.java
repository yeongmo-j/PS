"
[문제요약]
B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35



[해결방법]
걍 함

Time complexity : O(N)
Space complexity : O(N);

[추가]
@@@@@앞에서부터 해도 됨
앞에서 구한거에 B 곱하고 지금꺼 더하면 
"
import java.util.Scanner;

public class Main {

	static void toDecimal(String N, int B) {
		char[] c = N.toCharArray();
		int lastIdx = c.length-1;
		int bnary = 1;
		int result = 0;
		int now = 0;
		for (int i = lastIdx ; i>=0 ; i--) {
			if (c[i]>='A') {
				now = (int)(c[i]-'A'+10);
			} else {
				now = (int)(c[i]-'0');
			}
			result += now*bnary;
			bnary*=B;
		}
		System.out.println(result);
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		String N = scin.next();
		int B = scin.nextInt();
		toDecimal(N, B);

		scin.close();
	}
}
