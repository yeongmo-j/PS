'''
[문제요약]
2차원 배열로 섬이 주어지고
0은 바다,1은 섬임
섬은 하나이며, 동서남북으로 연결되어있음.
이 섬의 둘레의 길이를 구해라

[해결방법]
만약 그 배열의 한 원소가 1이면, 그때 동서남북을 판별하면 된다.
동서남북중에 바다가 있으면 1씩 더해주면 됨.

Time complexity : O(N) 배열의 크기 N
Space complexity : O(1)

[추가]
'''
class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int i, j;
        int peri=0;
        for (i=0 ; i<n ; i++)
        {
            for (j=0 ; j<m ; j++)
            {
                if (grid[i][j]==1)
                {
                    if (i<=0 || grid[i-1][j]==0)
                        peri++;
                    if (j>=m-1 || grid[i][j+1]==0)
                        peri++;
                    if (i>=n-1 || grid[i+1][j]==0)
                        peri++;
                    if (j<=0 || grid[i][j-1]==0)
                        peri++;
                }
            }
        }
        return peri;
    }
}
