"
[문제요약]
문자열이 들어오고, 명령문들이 들어오는데
커서를 움직이며 문자열을 조작하는 문제이다.

[해결방법]
커서를 움직일때 커서 앞의 문자와 커서 뒤의 문자를 어떻게 관리해주느냐가 문제.
그래서 커서의 왼쪽과 오른쪽의 문자들을 다루는 스택을 2개 관리해준다.
맨앞의 문자는 왼쪽스택 바닥에 존재하고,
맨뒤의 문자는 오른쪽스택 바닥에 존재한다.
(왼쪽스택) abcde (top)
(오른쪽스택) jihgf (top)
이런식으로 관리.

맨처음 문자열이 들어오면 왼쪽스택에 다 채운다.
커서를 오른쪽으로 옮기면 오른쪽스택 pop해서 왼쪽에 push
왼쪽으로 옮기면 왼쪽스택 pop해서 오른쪽에 push

마지막에 왼쪽스택 빌때까지 다 pop해서 오른쪽에 push 하면 완성본이 오른쪽에 존재하게 된다.
이제 다 꺼내서 출력.

Time complexity : O(N)
Space complexity : O(1);

[추가]
이것도 강의보고 푼거나 다름없음.

마지막에 출력할때 하나하나 System.out.print해주니 시간초과가 나왔다.
StringBuilder로 하나하나 추가해주고
마지막에 출력해주는게 더 빠른듯 하다.
"
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		String str = scin.next();
		for (char c : str.toCharArray())
			left.add(c);
		int N = scin.nextInt();
		char menu;
		char value;
		while (--N>=0) {
			menu = scin.next().charAt(0);
			if (menu=='L') {
				if (left.size()!=0)
					right.add(left.pop());
			}
			else if (menu=='D') {
				if (right.size()!=0)
					left.add(right.pop());
			}
			else if (menu=='B') {
				if (left.size()!=0)
					left.pop();
			}
			else {
				value = scin.next().charAt(0);
				left.add(value);
			}
		}
		while (!left.isEmpty()) {
			right.add(left.pop());
		}
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);

		scin.close();
	}
}
