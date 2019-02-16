'
[문제요약]
정수 배열이 들어오고, 부분 배열 중에서 연속적인 부분배열 중에 그 원소들의 총 합의 최대값을 리턴.

[해결방법]
일단 DP로 bottom up 해서 i부터 j까지의 합을 구하였다.
class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max = Integer.MIN_VALUE;
        if (size==0)
            return 0;
        int[][] cache = new int[size][size];
        for (int i=0 ; i<size ; i++){
            for (int j=0 ; j<size ; j++){
                //from i to j
                if (i==j)
                    cache[i][j]=nums[i];
                else if (i>j)
                    continue;
                else {
                    cache[i][j] = cache[i][j-1]+nums[j];
                }
                max = cache[i][j]>max ? cache[i][j] : max;
            }
        }
        return max;
    }
}
그랬더니 많은 입력이 들어올 경우에 메모리 초과가 되버렸음.
short로 바꿔도 입력이 int형이기 때문에 안됨.

그래서 분할정복으로 했더니 성공함.

Time Complexity = O(NlgN); T(n) = 2T(n/2)+theta(n);
Space Complecity = O(lgN) 스택의 크기 (반씩 줄어드는 크기)

[추가]
힌트를 보니 O(N)으로도 가능 하다고 되어있다??
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int current = 0;
        int global = Integer.MIN_VALUE;
        for(int num : nums){
            current = Math.max(num, current + num);
            global = Math.max(global, current);
        }
        return global;
    }
}

앞에서부터 계속 더해나간다.
나까지 더한거보다, 내가 더 크다면?? 그냥 @@@@@나로 새로 시작하는게@@@@ 낫다는 뜻이다!!!!!!
그러므로 그때부턴 섬이 나로 변하고 ,그걸로 최대값을 비교한다.

그리고 최대값 구할 때 Math.max(a, b) 이렇게 구할 것.

'

class Solution {
    int divideConquer(int p, int q, int[] nums){
        if (p>=q)
            return nums[p];
        int r = (p+q)/2;
        int left = divideConquer(p,r,nums);
        int right = divideConquer(r+1,q,nums);
        int leftMax = Integer.MIN_VALUE;
        int leftSum=0;
        for (int i=r ; i>=p ; i--){
            leftSum+=nums[i];
            if (leftMax<leftSum)
                leftMax=leftSum;
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum=0;
        for (int i=r+1 ; i<=q ; i++){
            rightSum+=nums[i];
            if (rightMax<rightSum)
                rightMax = rightSum;
        }
        int mid = leftMax+rightMax;
        if (mid>=left && mid>=right)
            return mid;
        else if (left>=mid && left>=right)
            return left;
        return right;
    }
    public int maxSubArray(int[] nums) {
        return divideConquer(0,nums.length-1,nums);
    }
}
