'''
[문제요약]
숫자 혹은 +,D,C가 들어오는데
들어오는 명령에 따라서 점수 계산하는 것.

[해결방법]
스택을 이용.
컬렉션프레임웍 대신에 배열로 사용했음.
스택에서 2개를 꺼내올 때가 있기 때문에, 경계체크를 매번 해줘야 했다.

Time complexity : O(N) 배열의 크기 N
Space complexity : O(N)

[추가]
'''
class Solution {
    public int calPoints(String[] ops) {
        int size = ops.length;
        int[] stack = new int[size];
        int top = -1;
        int last, lastlast;
        int score=0;
        for (String str : ops)
        {
            if (str.equals("+"))
            {
                if (top>=1)
                {
                    last=stack[top];
                    lastlast= stack[top-1];
                    score+=last+lastlast;
                    stack[++top]=last+lastlast;
                }
                else if (top>=0)
                {
                    last = stack[top];
                    score+=last;
                    stack[++top]=last;
                }
            }
            else if (str.equals("D"))
            {
                if (top>=0)
                {
                    last = stack[top];
                    stack[++top]=last*2;
                    score+=last*2;
                }
            }
            else if (str.equals("C"))
            {
                if (top>=0)
                    score-=stack[top--];
            }
            else
            {
                last = Integer.parseInt(str);
                score+=last;
                stack[++top]=last;
            }
        }
        return score;
    }
}
