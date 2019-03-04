'''
[문제요약]
배열이 있고, 또 목표배열이 있을 때,
원래의 배열을 스택에 푸쉬 ,팝 해서 목표배열을 만들 수 있으면
true, 아니면 false

[해결방법]
배열로 스택을 만들어줬다.
종료조건, 성공조건 잘 체크할것!!

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        int[] stack = new int[len];
        int top=-1;
        int toPop = 0;
        int now=0;
        while (now<len && toPop<len)
        {
            if (top>=0 && stack[top]==popped[toPop])
            {
                top--;
                toPop++;
            }
            else
                stack[++top]=pushed[now++];
        }
        if (top==-1)
            return true;
        while (toPop<len)
        {
            if (stack[top--]!=popped[toPop++])
                return false;
        }
        return true;
    }
}
