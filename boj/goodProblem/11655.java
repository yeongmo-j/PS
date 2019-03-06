"
[문제요약]
ROT13 암호화하기.
소문자는 소문자끼리, 대문자는대문자끼리 13번 다음으로 미룬다.
알파벳순으로 정렬해 놨을 때, a는 13번째 뒤의 알파벳으로 바뀌고 이런식으로 다 바꿔주면 된다.
대문자도 소문자도 아니면그대로.

예를 들어, Baekjoon Online Judge를 ROT13으로 암호화하면 Onrxwbba Bayvar Whqtr가 된다

[해결방법]
원소 하나하나마다 13씩 더해준다. 만약 그게 'z'나 'Z'를 넘으면 26을 뺴준다.

Time complexity : O(N)
Space complexity : O(1);

[추가]
char 연산 실수
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		String str = scin.nextLine();
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		char value;

		for (char c : arr) {
			if (c>='a' && c<='z') {
				//소문자
				value = (char)(c+13);
				if (value>'z')
					value = (char)(value-26);
				sb.append(value);
			}
			else if ( c>='A' && c<='Z') {
				//대문자
				value = (char)(c+13);
				if (value>'Z')
					value = (char)(value-26);
				sb.append(value);
			}
			else {
				sb.append(c);
			}
		}
		System.out.println(sb);
		scin.close();
	}
}
