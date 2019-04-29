"
[문제요약]
N*M배열에 각각 점수가 주어지고
1,1에서 N,M으로 이동할 때, 얻을 수 있는 최대 점
(오른쪽, 아래, 오른쪽아래대각선으로만 이동 가능함)

[해결방법]
DP 이용
maximum[i][j]는 i,j까지 얻을 수 있는 최대 점수
int now = maximum[i][j];
if (j+1<=M && maximum[i][j+1] < now+score[i][j+1])
    maximum[i][j+1] = now+score[i][j+1];


Time complexity : O(N*M)
Space complexity : O(N*M)

[추가]
반대로 생각해보면
maximum[i][j]는 i-1,j-1 / i-1,j / i,j-1 중에 가장 큰거에 score[i][j]를 더한거와 같다!!


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int N;
	static int M;
	static int[][]maximum;
	static int[][]score;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		maximum = new int[N+1][M+1];
		score = new int[N+1][M+1];
		int i, j;
		for (i=1 ; i<=N ; i++) {
			input = br.readLine().split(" ");
			for (j=1 ; j<=M ; j++)
				score[i][j] = Integer.parseInt(input[j-1]);
		}

		maximum[1][1] = score[1][1];
		for (i=1 ; i<=N ; i++) {
			for (j=1 ; j<=M ; j++) {
				int now = maximum[i][j];
				if (j+1<=M && maximum[i][j+1] < now+score[i][j+1])
					maximum[i][j+1] = now+score[i][j+1];
				if (i+1<=N && j+1<=M && maximum[i+1][j+1] < now+score[i+1][j+1])
					maximum[i+1][j+1] = now+score[i+1][j+1];
				if (i+1<=N && maximum[i+1][j] < now+score[i+1][j])
					maximum[i+1][j] = now+score[i+1][j];
			}
		}
		System.out.println(maximum[N][M]);
	}
}
