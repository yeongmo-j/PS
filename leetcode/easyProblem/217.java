"
[문제요약]
정수 배열이 들어오는데, 겹치는 정수 있으면 true 없으면 false

[해결방법]
set 이용했음.

Time complexity : O(N);
Space complexity : O(N)

[추가]
정렬 한뒤에 (nlgn)
하나씩 탐색해가며 뒤에꺼랑 같은지 봐도 된다.
"

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums){
            if (set.contains(n))
                return true;
            set.add(n);
        }
        return false;
    }
}
