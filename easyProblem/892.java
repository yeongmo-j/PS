'''
[문제요약]
2차원배열로 건물의 높이가 주어지고,
건물 전체의 면적 구하기.

[해결방법]
하나하나씩 원소 탐색해본다.
일단 0이 아니면 (위, 아래=2)추가해주고,
동,서,남,북 원소들과 비교해본다.
그래서 보이는 만큼만 추가해준다.

Time complexity : O(N); N은 원소의 개수
Space complexity : O(1);

[추가]
방향 탐색 할 때, 배열 쓰는것.
int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
'''

class Solution {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
        int count=0;
        int i, j, k;
        int newi, newj;
        for (i=0 ; i<row ; i++){
            for (j=0 ; j<col ; j++){
                if (grid[i][j]!=0){
                    count+=2;
                    for (k=0 ; k<4 ; k++){
                        newi = i+direction[k][0];
                        newj = j+direction[k][1];
                        if (newi<0 || newi>=row || newj<0 || newj>=col)
                            count+=grid[i][j];
                        else if (grid[i][j]>=grid[newi][newj])
                            count+=(grid[i][j]-grid[newi][newj]);
                    }
                }
            }
        }
        return count;
    }
}
