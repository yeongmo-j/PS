"
[문제요약]
m*n 배열이 들어오고
각 배열에는 숫자가 들어옴
4방향 이동 가능하고,
더 높은숫자에서 낮은숫자로만 이동할 수 있음
이때, 0,0에서 m-1,n-1로 이동하는 방법의 수를 구하여라

[해결방법]
DP이용
d[i][j]는 i,j에서 m-1,n-1로 이동하는 방법의 수
for (int x = 0 ; x<4 ; x++) {
    int nextI = i + dir[x][0];
    int nextJ = j + dir[x][1];
    if (nextI>=0 && nextI<m && nextJ>=0 && nextJ<n) {
        if (map[nextI][nextJ] < map[i][j]) {
            d[i][j] += go(nextI,nextJ);
        }
    }
}

Time complexity : O(n*m)
Space complexity : O(n*m)

[추가]
dp 시작하기 전에
배열 -1로 초기화해주는거 잊지말기!!

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int m;
	static int n;
	static int[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int[][] d;

	static int go(int i, int j) {
		if (i==m-1 && j==n-1) {
			return 1;
		}
		else if (d[i][j] >= 0 )
			return d[i][j];
		d[i][j] = 0;
		for (int x = 0 ; x<4 ; x++) {
			int nextI = i + dir[x][0];
			int nextJ = j + dir[x][1];
			if (nextI>=0 && nextI<m && nextJ>=0 && nextJ<n) {
				if (map[nextI][nextJ] < map[i][j]) {
					d[i][j] += go(nextI,nextJ);
				}
			}
		}
		return d[i][j];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		m = Integer.parseInt(input[0]);
		n = Integer.parseInt(input[1]);
		map = new int[m][n];
		d = new int [m][n];
		int i, j;
		for (i=0 ; i<m ; i++) {
			for (j=0 ; j<n ; j++)
				d[i][j] = -1;
		}

		for (i=0 ; i<m ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<n ; j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		System.out.println(go(0, 0));
	}
}
