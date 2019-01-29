"
[문제요약]
배열이 주어지고, 배열중에 3 원소를 골라 그 곱이 제일 큰 값을 찾아라.

[해결방법]
일단 정렬을 한다.
최대가 되는 방법은 다음과 같다.
1. 셋다 양수일경우
2. 둘은 음수, 셋은 양수일 경우
3. 전부다 음수일 경우, 제일 큰 음수 3개(절대값이 제일 작은 음수 3개)
여기서 1,3은 정렬된 배열의 마지막 3원소를 곱하는 것이다.
2는 배열 처음2원소, 마지막1원소를 곱하는 것이다.

Time complexity : O(NlgN); 정렬을 위해
Space complexity : O(1)

[추가]
@@@@@좋은방법@@@@@@
굳이 3 케이스로 나눠 할 필요 없이,
1,3번은 둘다 같은 인덱스를 곱하는 것이므로,
[0]*[n-1]*[n-2] vs [n-1][n-2][n-3]
을 비교 해주면 너무 간단한 문제.


아니면 정렬을 하지 않고,
제일 작은 2원소,
제일 큰 3원소를 직접 구하는 것도 됨!!!!
이렇게.
public class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}

"

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int case1 = Integer.MIN_VALUE;
        int case2 = Integer.MIN_VALUE;
        int case3 = Integer.MIN_VALUE;
        if (nums[len-1]>=0 && nums[len-2]>=0 && nums[len-3]>=0)
            case1 = nums[len-1]*nums[len-2]*nums[len-3];
        if (nums[len-1]>=0 && nums[0]<0 && nums[1]<0)
            case2 = nums[len-1]*nums[0]*nums[1];
        if (nums[len-1]<0)
            case3 = nums[len-1]*nums[len-2]*nums[len-3];
        return Math.max(Math.max(case1, case2),case3);
    }
}
