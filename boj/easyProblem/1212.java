"
[문제요약]
8진수를 2진수로 바꿔서 출력하기

[해결방법]
한자리씩 끊어서 그걸 2진수 3자리로 바꿔서 출력해주면 됨.
어차피 경우가 0~7까지 8개밖에 없으니까 크기 8의 String 배열로 출력을 해주었음.
맨앞에껀 0으로 시작하면 안되니까 또 맨앞에꺼용 배열을 하나 더 만들어줬음.

Time complexity : O(N)
Space complexity : O(N);

[추가]
입력 범위 주의!!!!
만약 0이 들어온다면 이것도 생각해주 ㅓ야 함!!

"

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		String str = scin.next();
		char[] carr = str.toCharArray();
		int lastIdx = carr.length-1;
		String[] first = {"0", "1","10","11","100","101","110","111"};
		String[] left = {"000", "001","010","011","100","101","110","111"};
		if (lastIdx>=0) {
			System.out.print(first[(int)(carr[0]-'0')]);
		}
		for (int i=1 ; i<=lastIdx ; i++) {
			System.out.print(left[(int)(carr[i]-'0')]);
		}

		scin.close();
	}
}
