'''
[문제요약]
⌊ n/2 ⌋ times 이상 나온 원소 찾기

[해결방법]
Map으로 하나하나 다 세봄. 중간에 계속 조건 체크.
base case(1개 혹은 0개 들어올 때 잘 체크하기!)

Time Complexity = O(N);
Space Complecity = O(N);

[추가]
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
속도는 더 느리지만 정렬로 하는 방법도 있음
public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
정렬해놓고 가운데꺼 보내면 됨....
앞에서 해도 오른쪽에서 해도 결국 중간꺼는 제일 큰거임....!!!!!!!

'''
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int least = len/2;
        int temp;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums){
            if (map.containsKey(num)){
                temp = map.get(num)+1;
                if (temp>least)
                    return num;
                map.replace(num,temp);
            }
            else{
                if (least<1)
                    return num;
                map.put(num,1);

            }
        }
        return -1;
    }
}
