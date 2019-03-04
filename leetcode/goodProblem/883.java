'''
[문제요약]
2차원 배열 들어오고, 이 뜻은 i,j의 위치에 x높이의 건물이 있다는 뜻
앞에서, 옆에서, 위에서 본 모습을 2차원 모눈종이에 나타낼 때, 색칠되는 칸의 합

[해결방법]
각 행에서 제일 큰 원소 골라서 합하고 ( 옆에서 본모습)
각 열에서 제일 큰 원소 곱해서 합했다 (앞에서 본모습)
또한, 원소가 0이 아니면 1씩 더해줬다 (위에서 본모습)

Time complexity : O(N^2) N은 행(열)의 사이즈
Space complexity : O(N)

[추가]
탐색할 때 i기준으로 j 를 0부터 n까지 루프를 도는데
grid[i][j]를 돌려서 행기준 최대값을 찾고
grid[j][i]를 돌려서 열기준 최대값을 찾으면 한번에 그 행, 그 열에서의 모습을 찾을 수 있다!!!!
for (int i = 0; i < N;  ++i) {
           int bestRow = 0;  // largest of grid[i][j]
           int bestCol = 0;  // largest of grid[j][i]
           for (int j = 0; j < N; ++j) {
               if (grid[i][j] > 0) ans++;  // top shadow
               bestRow = Math.max(bestRow, grid[i][j]);
               bestCol = Math.max(bestCol, grid[j][i]);
           }
           ans += bestRow + bestCol;
       }
'''

class Solution {
    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int[] front = new int[len];
        int[] side = new int[len];
        int i, j;
        int unit;
        int sum = 0;
        for (i=0 ; i<len ; i++)
        {
            for (j=0 ; j<len ; j++)
            {
                unit = grid[i][j];
                if (front[j] < unit)
                    front[j] = unit;
                if (side[i] < unit)
                    side[i] = unit;
                if (unit!=0)
                    sum++;
            }
        }
        for (i=0 ; i<len ; i++)
            sum+=(front[i] + side[i]);
        return sum;
    }
}
