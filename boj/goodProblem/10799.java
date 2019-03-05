"
[문제요약]
괄호 형태로 문자열이 들어오고,
()처럼 붙어나오면 레이저,
떨어진 괄호면 그 길이만큼 막대기의 길이이다.
레이저로 인해 나눠진 모든 막대기의 개수를 구하라.

[해결방법]
일단 스택을 사용해서
(가 들어오면 그 인덱스를 스택에 저장한다.
그다음 )가 발견되면 pop을 해서 맨위의 인덱스가 뭔지 확인한다.
그래서 ()가 연속으로 들어온게 확인되면, 그게 레이저이다.
레이저가 들어오면 현재까지 존재하는(끝마치지 않은 막대기)의 개수만큼 두동강이 나므로 그만큼 추가해준다.
이는 스택의 사이즈이다.
결국, 레이저가 들어오면 스택의 사이즈만큼 더해주면 된다.

()가 연속으로 들어온게 아니라면, 막대기의 끝을 의미한다.
그래서 1을 더해준다.(두동강 내가며 앞의 것들만 더해주고, 맨뒤에껀 안더해줬음)


Time complexity : O(N)
Space complexity : O(1);

[추가]
이건 강의보고 푼거나 다름없음.

"
import java.util.Scanner;

class List{
	int data;
	List before;
	List() {
		data = 0;
		before = null;
	}
	List(int data, List before){
		this.data = data;
		this.before = before;
	}
}

class Stack{
	int size;
	List top;
	Stack() {
		size = 0;
		top = null;
	}
	void push(int x) {
		List temp = new List(x, top);
		top = temp;
		size++;
	}
	int pop() {
		int result = top.data;
		top = top.before;
		size--;
		return result;
	}
	int size() {
		return size;
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		Stack stack = new Stack();
		String str = scin.next();
		char[] arr = str.toCharArray();
		int top;
		int result=0;
		for (int i=0 ; i<arr.length ; i++) {
			if (arr[i]=='(')
				stack.push(i);
			else {
				top = stack.pop();
				if (top==i-1) {
					result += stack.size();
				}
				else {
					result += 1;
				}
			}
		}
		result += stack.size();
		System.out.println(result);
		scin.close();
	}
}
