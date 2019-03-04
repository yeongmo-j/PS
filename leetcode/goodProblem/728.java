'''
[문제요약]
128은 1, 2, 8로 각각 다 나누어 떨어진다.
이처럼 각 자리수로 나누어 떨어지는 수들을 찾아라
하나라도 0이 있으면 안되는거임.
주어진 범위 내에서 저거에 해당되는 모든 수 찾아라

[해결방법]
하나하나 다 해봤다.

time complexity 생각하는법!!!!!!!!!
Time complexity : O(N*logR) n은 구역 안의 개수 / R은 최대값(lg가 아니라 log다)
Space complexity : O(1)

[추가]
char c: String.valueOf(n).toCharArray())

이렇게 사용하면 숫자의 각 자리수를 떼어낼 수 있다.

'''

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        int self;
        int temp, digit;
        boolean isDivide;
        List<Integer> list = new ArrayList<Integer>();
        for (self=left ; self<=right ; self++)
        {
            temp=1;
            isDivide = true;
            while (self/temp > 0)
            {
                digit = (self/temp)%10;
                if (digit==0||self%digit!=0)
                {
                    isDivide=false;
                    break;
                }
                temp*=10;
            }
            if (isDivide)
                list.add(self);
        }
        return list;
    }
}
