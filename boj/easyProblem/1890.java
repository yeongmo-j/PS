"
[문제요약]
N*N배열이 주어지고
각 칸에는 이동할 수 있는 칸의 길이가 주어진다.
그래서 그 칸에 적힌 대로 오른쪽, 아래로 이동 할 수 있다
0,0에서 시작해서 N-1,N-1로 이동할 수 있는 방법의 수를 출력

[해결방법]
DP 이용
d[i][j]는 i,j까지 이동할 수 있는 경우의 수
if (d[i][j]!=0 && !(i==N-1 && j==N-1)) {
    int go = cango[i][j];
    if (i+go<N)
        d[i+go][j]+=d[i][j];
    if (j+go<N)
        d[i][j+go]+=d[i][j];
}

Time complexity : O(N^2)
Space complexity : O(N^2)

[추가]


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int N;
	static long[][]d;
	static int[][]cango;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		d = new long[N][N];
		cango = new int[N][N];
		int i, j;
		for (i=0 ; i<N ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<N ; j++)
				cango[i][j] = Integer.parseInt(input[j]);
		}
		d[0][0] = 1L;
		for (i=0 ; i<N ; i++) {
			for (j=0 ; j<N ; j++) {
				if (d[i][j]!=0 && !(i==N-1 && j==N-1)) {
					int go = cango[i][j];
					if (i+go<N)
						d[i+go][j]+=d[i][j];
					if (j+go<N)
						d[i][j+go]+=d[i][j];
				}
			}
		}

		System.out.println(d[N-1][N-1]);
	}
}
