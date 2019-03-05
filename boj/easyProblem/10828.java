"
[문제요약]
스택 구현하기.

[해결방법]
리스트 클래스 만들고, 스택 클래스를 만들었다.
리스트 클래스의 멤버는 데이터와, 그 전의 리스트를 가르키는 포인터로 구성되어 있고,
스택 클래스의 멤버는 사이즈와, 리스트 자료형의 top으로 구성되어 있다.

Time complexity : O(N) (모든 연산이 O(1)이다.)
Space complexity : O(1);

[추가]


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
	void pop() {
		if (size<=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(top.data);
		top = top.before;
		size--;
	}
	void size() {
		System.out.println(size);
	}
	void empty() {
		int result = size<=0 ? 1 : 0;
		System.out.println(result);
	}
	void top() {
		if (size<=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(top.data);
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		String order;
		int num;
		Stack stack = new Stack();
		while (--N>=0) {
			order = scin.next();
			switch (order) {
			case "push" :
				num = scin.nextInt();
				stack.push(num);
				break;
			case "pop" :
				stack.pop();
				break;
			case "size" :
				stack.size();
				break;
			case "empty" :
				stack.empty();
				break;
			case "top" :
				stack.top();
			}
		}
		scin.close();
	}
}
