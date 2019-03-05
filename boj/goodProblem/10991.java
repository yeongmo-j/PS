"
[문제요약]
별찍기

[해결방법]


Time complexity : O(N)
Space complexity : O(1);

[추가]
하나하나 출력하지 말고
+연산으로 String에 추가한 다음에
마지막에 한번만 출력해주면 더욱 간편함.
이것때문에 good에 넣어놓음.

그리고 마지막줄 빈 선 출력 금지

"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int i, j;
		String line;
		for (i=1 ; i<=N ; i++) {
			line="";
			for (j=0 ; j<N-i ; j++)
				line+=" ";
			for (j=0 ; j<i-1 ; j++)
				line+="* ";
			line+="*";
			System.out.println(line);
		}
		scin.close();
	}
}
