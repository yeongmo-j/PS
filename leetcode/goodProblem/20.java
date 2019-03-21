"
[문제요약]
(){}[]
괄호가 입력으로 들어 올때,
괄호가 제대로된 괄호니?(여러개 괄호가 제대로 된거니 )

[해결방법]
스택 사용

Time complexity : O(N) (전체 문자열의 문자개수)
Space complexity : O(N)

[추가]
@@@@@@@
매우 좋은 방법
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
아예 나와야 하는 걸 집어넣어 버리면 됨!!
"
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for (char c : arr){
            if (c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if (stack.size()<=0)
                    return false;
                char popped = stack.pop();
                if (popped=='('){
                    if (c!=')')
                        return false;
                }
                else if (popped=='{') {
                    if (c!='}')
                        return false;
                }
                else {
                    if (c!=']')
                        return false;
                }
            }
        }
        if (stack.size()==0)
            return true;
        return false;
    }
}
