"
[문제요약]
배열의 길이가 n이면 0~n까지의 숫자중 하나 빼고 배열에 다 들어있다. 그 나머지 하나 구해라.

[해결방법]
n(n+1)/2가 원래 합이니까
여기서 원소들 다 빼주면 남는게 하나 있다.

Time complexity : O(N);
Space complexity : O(1)

[추가]

"

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len*(len+1)/2;
        for (int num : nums)
            sum-=num;
        return sum;
    }
}
