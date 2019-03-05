"
[문제요약]
1,2
3,4
처럼 ,로 구분된 숫자 두개씩 합해서
한줄에 하나씩 결과 출력하기

[해결방법]
String으로 입력 받아서 indexOf(',')를 이용해서 substring으로 잘라서 사용하였다.


Time complexity : O()
Space complexity : O(1);

[추가]
String a[] = new String[2];
이렇게 만들어놓고
a = str.split(",");
이렇게 split으로 잘라놓아도 된다.(인자는 String)
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int T = scin.nextInt();
		String str;
		int idx;
		for (int i=0 ; i<T ; i++) {
			str = scin.next();
			idx = str.indexOf(',');
			System.out.println(Integer.parseInt(str.substring(0,idx))
					+Integer.parseInt(str.substring(idx+1)));
		}
		scin.close();
	}
}
