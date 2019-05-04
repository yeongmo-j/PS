"
[문제요약]
빌딩 n개가 일렬로 있을때
높이는 1~n이고 안겹침
왼쪽에서 봤을 떄 l개 오른쪽에서 봤을 때 r개가 보일 때
건물들이 있을 수 있는 경우의 수!를 출력
1000000007로 나눈 나머지를 출력.

[해결방법]
dp를 이용
일단 건물이 2~i까지 있다고 하고(i-1개) 여기에 1을 껴넣는다고 생각하자.
맨앞에 껴넣으면? 왼쪽에서 보는거만 1 늘음
맨뒤에 껴넣으면? 오른쪽에서 보는거만 1 늘음
중간에 넣으면? 보이는건 변화 없음. 하지만 이게 (2~i건물의 수-1)개 있음

즉, 이를 점화식으로 나타내면
d[i][j][k] = i개를 왼쪽에서보면 j개 오른쪽에서보면 k개가 보인다.
d[i+1][j+1][k] += d[i][j][k] (맨앞에놓음)
d[i+1][j][k+1] += d[i][j][k] (맨뒤에놓음)
d[i+1][j][k] += (i-1)d[i][j][k] (중간에 놓음)
이 된다.
각 스텝에선, i가 무조건 1씩 증가해서 더해주므로, 현재 i에 해당하는 값들은 바뀔 일이 없다.
그러므로 i기준으로 앞에서부터 시작해주면 되는데,
시작은 d[1][1][1] = 1로 시작해준다.

Time complexity : O(n^3)
Space complexity : O(n^3)

[추가]

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int n;
	static int l;
	static int r;
	static long[][][] d;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		l = Integer.parseInt(input[1]);
		r = Integer.parseInt(input[2]);
		d = new long[n+1][n+1][n+1];
		int i, j, k;
		d[1][1][1] = 1L;
		for (i=1 ; i<n ; i++) {
			for (j=1 ; j<=i ; j++) {
				for (k=1 ; k<=i ; k++) {
					long num = d[i][j][k];
					if (num!=0) {
						d[i+1][j+1][k] += num;
						d[i+1][j+1][k]%=1000000007;
						d[i+1][j][k] += (i-1)*num;
						d[i+1][j][k]%=1000000007;
						d[i+1][j][k+1] += num;
						d[i+1][j][k+1]%=1000000007;
					}
				}
			}
		}
		System.out.println(d[n][l][r]%1000000007);

	}
}
