'''
[문제요약]
m*n행렬에서 a*b행렬로 바꾸기.
행기준으로 읽은 순서가 동일해야 함.

[해결방법]

Time complexity : O(m*n);
Space complexity : O(m*n);

[추가]

'''
class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int originR = nums.length;
        int originC = nums[0].length;
        int[][] newArr = new int[r][c];
        int num=0;
        if (originR*originC != r*c)
            return nums;
        int i, j;
        for (i=0 ; i<r ; i++)
        {
            for (j=0 ; j<c ; j++)
            {
                newArr[i][j]=nums[num/originC][num%originC];
                num++;
            }
        }
        return newArr;
    }
}
