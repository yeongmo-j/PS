"
[문제요약]
2차원 배열이 들어오는데,
해당 원소와 그를 둘러싸고 있는 모든 원소의 평균으로 이루어져있는 2차원 배열 리턴.
(평균을 내는데 사용되는 원소는 최대 9개가 됨. 최소 4개)

[해결방법]
하나하나 확인했다.

Time complexity : O(N);N은 원소의 개수 (배열의 전체크기)
Space complexity : O(N)

[추가]
이동할때 2차원 배열 만들어서 이동하는 경우도 있지만,
for (int nr = r-1; nr <= r+1; ++nr)
    for (int nc = c-1; nc <= c+1; ++nc) {
        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
            ans[r][c] += M[nr][nc];
            count++;
        }
    }

이렇게 주어진 범위 내에서 -1~+1을 두번 겹쳐서 사용할 수도 있다!!

"

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int sum, count;
        int[][] move = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int[][] result = new int[n][m];
        int x, y;
        for (int i=0; i<n ; i++){
            for (int j=0 ; j<m ; j++){
                sum=M[i][j];
                count=1;
                for (int k=0 ; k<8 ; k++){
                    x=i+move[k][0];
                    y=j+move[k][1];
                    if (x>=0 && x<n && y>=0 && y<m){
                        count++;
                        sum+=M[x][y];
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}
