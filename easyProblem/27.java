"
[문제요약]
정수 배열과 값이 들어오고,
배열에서 값을 다 없앤 길이를 리턴하라.
길이를 리턴함과 동시에,
원래 배열에 결과 길이까지의 배열에는 해당 값을 없앤 배열의 원소들로 채워져야 있어야 한다.
즉 Given nums = [3,2,2,3], val = 3,
이면, 3을 다 없애고 [2,2,~,~]
의 형태로 만들고, 결과로 2를 리턴해야 한다.
공간 O(1)만 사용가능함.

[해결방법]
배열로 돌려가며, 만약 해당 값이 아니면 arr[count]에다가 그 값을 저장시키고,
count를 1 추가시킨다. 이렇게되면, 원하는 값들만 앞에서부터 채워진다.
count는 현재 원소의 인덱스 초과가 될 수 없으므로, 괜찮다.

Time complexity : O(N)
Space complexity : O(1);

[추가]
"
class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for (int n : nums)
            if (n!=val){
                nums[count++] = n;
            }
        return count;
    }
}
