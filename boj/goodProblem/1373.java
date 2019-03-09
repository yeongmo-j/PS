"
[문제요약]
2진수를 8진수로 바꿔서 출력하기

[해결방법]
세자리씩 끊어서 !!세자리씩!!을 각 8진수로 바꿔서 출력하면 된다는 것을 알게 되었다.
그런데 3자리로 나누어 떨어지지 않을 경우, 그 나머지는 앞에서 처리를 해 준다.


Time complexity : O(N)
Space complexity : O(N);

[추가]
은근히 오래걸렸고 많이 틀렸다!
"

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		String str = scin.next();
		char[] carr = str.toCharArray();
		int lastIdx = carr.length-1;
		if (carr.length%3==1) {
			System.out.print(carr[0]-'0');
		} else if (carr.length%3==2) {
			System.out.print((carr[0]-'0')*2+(carr[1]-'0'));
		}
		int i;
		for (i=carr.length%3 ; i<lastIdx ; i+=3) {
			System.out.print((carr[i]-'0')*4+(carr[i+1]-'0')*2 + (carr[i+2]-'0'));
		}
		scin.close();
	}
}
