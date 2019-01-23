'''
[문제요약]
숫자를 이진수로 바꿨을 때, 각 자리수가 1010으로 반복되는지?

[해결방법]
1010 반복되는수는
전의 수에 2를 곱하고, 그 수에 2를 곱한뒤에 1씩 더한 수로 반복된다.
고로 1에서 시작해 입력 수보다 작거나 같을 동안, 2 곱하고, 2곱하고1더하고를 반복한다.

Time complexity : O(lgN); N은 입력되는 숫자.
Space complexity : O(1);

[추가]
오버플로우 조심.
'''
class Solution {
    public boolean hasAlternatingBits(int n) {
        long sum = 1L;
        int count=0;
        if (n<=2)
            return true;
        do
        {
            if (sum==n)
                return true;
            sum*=2L;
            if(count%2==1)
                sum++;
            count++;
        } while (sum<=n);
        return false;
    }
}
