'''
[문제요약]
배열이 주어지는데, 그 중에서 나머지는 다 2개씩인데 하나만 유일하다.
그 유일한거 찾아라

[해결방법]
set

Time complexity : O(N);
Space complexity : O(N);

[추가]
@@@@@좋은방법@@@@@
비트연산을 이용한다.
xor연산을 할때
a xor a = 0
a xor 0 = a
a xor b xor a = a xor a xor b = 0 xor b = b
즉 유일한 b만 남는다.
그래서 전부 다 비트연산 해줘라 (파이썬코드임)
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a = 0
        for i in nums:
            a ^= i
        return a
'''

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
        {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        int num = 0;
        Iterator iter = set.iterator();
        if (iter.hasNext())
            num=(Integer)iter.next();
        return num;

    }
}
