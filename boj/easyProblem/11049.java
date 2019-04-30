"
[문제요약]
행렬의 곱 최소로 만들기 문제

[해결방법]
DP이용
d[i][j] = i부터 j까지 곱하는데 드는 최소의 곱셈 연산
d[i][j] = d[i][k] + d[k+1][j] + c[i][0]*c[k][1]*c[j][1] 중에 최소 (i<=k<j)
c[i] = {행, 열}
로 들어와있음
c[i][0]*c[k][1]*c[j][1]은 그 전체 행렬의 곱셈 회수임

Time complexity : O(n*n)
Space complexity : O(n*n)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int[][] c = new int[n][2];
		int i, j;
		for (i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			c[i][0] = Integer.parseInt(input[0]);
			c[i][1] = Integer.parseInt(input[1]);
		}
		int[][] d = new int [n][n];
		for (int l=1 ; l<n ; l++) {
			for (i=0 ; i<n-l ; i++) {
				j = i + l;
				int min = Integer.MAX_VALUE;
				for (int m=i ; m<j ; m++) {
					min = Integer.min(min, d[i][m] + d[m+1][j] + c[i][0]*c[m][1]*c[j][1]);
				}
				d[i][j] = min;
			}
		}
		System.out.println(d[0][n-1]);
	}
}
