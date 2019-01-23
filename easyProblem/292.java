'''
[문제요약]
31게임 하는데
누가 이김?

[해결방법]
두명이 짝 이뤄서 4의 배수를 맞추는데 승리조건 맞추기

Time complexity : O(1);
Space complexity : O(1);

[추가]
'''

class Solution {
    public boolean canWinNim(int n) {
        if (n%4==0)
            return false;
        return true;
    }
}
