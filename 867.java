'''
[문제요약]
row*col 의 행렬 주어지고,
transpose matrix 만들기. (대각행렬을 기준으로 뒤집기)

[해결방법]
col*row 사이즈의 배열 하나 만들고
i와 j를 바꿔주었다.

Time complexity : O(row*col);
Space complexity : O(row*col);

[추가]

'''

class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int [][] newarr = new int[col][row];
        int i, j;
        for (i=0 ; i<row ; i++)
            for (j=0 ; j<col ; j++)
                newarr[j][i] = A[i][j];
        return newarr;
    }
}
