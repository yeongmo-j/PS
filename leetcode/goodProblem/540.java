'''
[문제요약]
정렬된 배열이 들어오는데,
나머지는 다 2개씩인데
하나는 하나임
그 단하나만 있는 하나 찾기.

[해결방법]
시간이 O(lgN)으로 정해져있다는 힌트를 이용해서,
배열을 반으로 줄여나가야한다는걸 알아냈다.
양 끝점의 중앙값을 기준으로, 중앙값과 왼쪽값이 같거나, 오른쪽값이 같은걸 판별해서 줄여나가는데,
지금 양끝점사이의 배열의 원소가 짝수인지, 홀수인지에 따라 달라진다.
 이걸 이용해서 분기로 줄여나가면 된다.


Time complexity : O(lgN);
Space complexity : O(1);

[추가]
좋은 문제.
'''
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int rear = nums.length-1;
        int front = 0;
        int middle = 0;
        while (front+2<rear)
        {
            middle = front+(rear-front)/2;
            if ((rear-middle)%2==1){
                if (nums[middle-1]==nums[middle])
                    front = middle+1;
                else
                    rear = middle-1;
            }
            else{
                if (nums[middle-1]==nums[middle])
                    rear = middle;
                else
                    front = middle;
            }
        }
        if (front+2==rear){
            if (nums[front]==nums[front+1])
                return nums[front+2];
            else
                return nums[front];
        }
        return -1;
    }
}
