"
[문제요약]
큐 구현

[해결방법]
리스트클래스(멤버 : 값, 다음 리스트의 포인터)와 큐 클래스(멤버 : 사이즈, 맨앞리스트, 맨뒤리스트)를
만들어서 각 연산 구현

Time complexity : O(N)
Space complexity : O(1);

[추가]
"
import java.util.Scanner;

class List{
	int data;
	List next;
	List() {}
	List(int data, List next){
		this.data = data;
		this.next = next;
	}
}

class Queue {
	int size;
	List front;
	List rear;
	Queue() {
		size = 0;
		front = null;
		rear = null;
	}
	void push(int x) {
		List temp = new List(x , null);
		if (size==0)
			front = temp;
		else
			rear.next = temp;
		rear = temp;
		size++;
	}

	void pop() {
		if (size<=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(front.data);
		front = front.next;
		size--;
	}

	void size() {
		System.out.println(size);
	}

	void empty() {
		int result = size==0 ? 1 : 0;
		System.out.println(result);
	}

	void front() {
		if (size<=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(front.data);
	}

	void back() {
		if (size<=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(rear.data);
	}
}


public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		Queue queue = new Queue();
		int N = scin.nextInt();
		String menu;
		int value;
		while (--N>=0) {
			menu = scin.next();
			switch(menu) {
			case "push" :
				value = scin.nextInt();
				queue.push(value);
				break;
			case "pop" :
				queue.pop();
				break;
			case "size" :
				queue.size();
				break;
			case "empty" :
				queue.empty();
				break;
			case "front" :
				queue.front();
				break;
			case "back" :
				queue.back();
			}
		}
		scin.close();
	}
}
