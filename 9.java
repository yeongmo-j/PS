"
[문제요약]
Palindrome인지 확인해라.
그대신, 문자열로 바꿔서 확인하지 마셈

[해결방법]
10억자리수 (integer의 최대)부터 10씩 나눠가며,
input의 최대자리를 구한 뒤에,1부터 시작하는 최소자리수의 자리수를 비교한다.
루프를 돌리며, 최대자리는 10씩 나눠가고, 최소자리는 10씩 곱해가며
최대자리가 최소자리보다 작아지면, 종료한다.
중간에 한번이라도 다르면 false


Time complexity : O(N) N은 자리수.
Space complexity : O(1);

[추가]
루프의 증감, 종료조건 잘 확인할 것.
(10씩 나누고, 곱해야 하고,
둘이 교차하면 루프 끝낼 것.)
"

class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        if (x<10)
            return true;
        int front = 1000000000;
        while (x/front==0)
            front/=10;
        int back = 1;
        int f=0, b=0;
        while (front>back){
            f = (x/front)%10;
            b = (x/back)%10;
            if (f!=b)
                return false;
            front/=10;
            back*=10;
        }
        return true;
    }
}
