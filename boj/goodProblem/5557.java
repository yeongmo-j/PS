"
[문제요약]
숫자 띄어쓰기 기준으로 여러개가 들어오고
a b c d e 이렇게 5개가 들어온다면?
a?b?c?d=e가 완성 되게
?안에 +나 -를 집어 넣을 수 있는 모든 경우의 수를 구하여라.
중간결과나 최종결과 다 0과 20 사이에 있어야 한다.


[해결방법]
d[i][j] = i번째 수까지 연산을 마쳤을 때, j가 되는 정의의 수.
d[i][j]에서 다음꺼로 나아갈 때
d[i+1][j+arr[i+1]] += arr[i][j]
d[i+1][j-arr[i+1]] += arr[i][j]
가 된다. 여기서 범위체크 해줘야 함.

그러고 마지막엔 d[n-2][arr[n-1]]을 호출 해준게 답이다.
왜냐면 입력의 인덱스는 0~n-1까진데, n-2번째까지 연산을 해준 결과가 arr[n-1]과 같아야 하므로

Time complexity : O(n*20)
Space complexity : O(n*20)

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
		input = br.readLine().split(" ");
		int i, j;
		int[] arr = new int [n];
		for (i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(input[i]);
		long[][] d = new long[n][21];
		d[0][arr[0]] = 1L;
		for (i=0 ; i<=n-2 ; i++) {
			for (j=0 ; j<=20 ; j++) {
				if (d[i][j]!=0) {
					int next=i+1;
					if (j+arr[next]<=20)
						d[next][j+arr[next]]+=d[i][j];
					if (j-arr[next]>=0)
						d[next][j-arr[next]]+=d[i][j];
				}
			}
		}
		System.out.println(d[n-2][arr[n-1]]);
	}
}
