"
[문제요약]
스택만으로
큐 연산 구현하기

[해결방법]
pop 이나 peek은
다 꺼낸다음에 다시 넣는걸로 바꿔줬음.


Time complexity : O(N) 각 연산당 O(N), N은 스택에 들어있는 원소 수.
Space complexity : O(N);

[추가]

"

class MyQueue {
    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        int result = temp.pop();
        while (!temp.empty()){
            stack.push(temp.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        int result = temp.peek();
        while (!temp.empty()){
            stack.push(temp.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
