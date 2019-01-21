'''
[문제요약]
배열에서 0이 아닌것들은 그 순서대로 앞쪽으로, 0인것들은 다 뒷쪽으로 몰아놓기

[해결방법]
일단 인덱스 저장해놓을 변수 하나를 저장해놓고(0으로 초기화)
앞에서부터 탐색해가며 0이 아니면
배열[인덱스++]=값으로 저장해놓는다.
또, 지나간 배열은 0으로 값을 바꿔놓는다.
이렇게되면, 지나가는 모든 부분은 0으로 변하고,
0이 아니면 앞에서부터 채워지게 된다.

Time complexity : O(N);
Space complexity : O(1);

[추가]

'''
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i;
        int idx=0;
        for (i=0 ; i<length ; i++){
            if (nums[i]!=0){
                nums[idx++]=nums[i];
                nums[i]=0;
            }
        }
    }
}
