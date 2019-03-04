'''
[문제요약]
1이 연속으로 제일 길게나오는거 찾기

[해결방법]
뒤에서부터 뒤에께 1이면 1씩 늘려가며 연속되는거 저장하다가,
제일 큰 수 찾으면 됨.

Time complexity : O(N);
Space complexity : O(1);

[추가]


'''

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int i;
        for (i = length-2 ; i>=0 ; i--){
            if (nums[i]==1)
                nums[i]+=nums[i+1];
        }
        int max = 0;
        for (i = 0 ; i<length ; i++){
            if (nums[i]>max)
                max = nums[i];
        }
        return max;
    }
}
