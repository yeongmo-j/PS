"
[문제요약]
N개의 숫자가 들어오고
s부터 e까지의 숫자가 팰린드롬인지 확인하라
N은 2000까지이고, 팰린드롬인지 확인하는 질의는 백만개까지가 들어온다

[해결방법]
DP 이용
D[i][j]는 i부터 j까지가 팰린드롬이면 true 아니면 false

일단 D[i][i]는 true이다
또 D[i][i+1]은 i번째수와 i+1번째수가 같으면 true 아니면 false

나머지
D[i][j] = D[i+1][j-1]가 true이고 i번째수==j번째수이면 true
이외에는 false
이다

Bottom up으로 구하기 위해서
n*n 배열에 대각선배열과 그 오른쪽 배열을 구해놓은다
그다음 오른쪽아래대각선방향으로 한줄씩 구해나간다
\
 \ 이 방향으로

Time complexity : O(n*n + m) (m은 질의의 개수)
Space complexity : O(n*n)

[추가]
출력이 많을 때는 꼭!!!!!!
StringBuilder 써주도록 하자!!!!!

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		arr = new int[n];
		input = br.readLine().split(" ");
		int i, j;

		for(i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(input[i]);

		boolean[][] d = new boolean[n][n];

		for (i=0 ; i<n ; i++)
			d[i][i] = true;

		for (i=0 ; i<n-1 ; i++) {
			j = i+1;
			if (arr[j]==arr[i])
				d[i][j] = true;
			else
				d[i][j] = false;
		}

		for (int l=2 ; l<n ; l++) {
			for (i=0 ; i<n-l ; i++) {
				j=i+l;
				if (d[i+1][j-1]==true && arr[i]==arr[j])
					d[i][j] = true;
				else
					d[i][j] = false;
			}
		}

		int m = Integer.parseInt(br.readLine().trim());
		StringBuilder stb = new StringBuilder();
		while (--m>=0) {
			input = br.readLine().split(" ");
			boolean result = d[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1];
			if (result)
				stb.append(1+"\n");
			else
				stb.append(0+"\n");
		}
		System.out.print(stb);
	}
}
