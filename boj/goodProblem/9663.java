"
[문제요약]
n*n크기의 체스판에
서로 공격할 수 없는 n개의 퀸을 놓을 수 있는 총 가지의 수를 구하여라


[해결방법]
이거는 각 행에 대해, 놓을 수 있는 퀸의 개수를 구해가며 다음 행으로 넘기는 재귀로 구할 수가 있다.
재귀함수 정의 : cals(int row) : row행에 놓을 퀸을 정함
row>=n이 되면 count 해주고, 이 count값이 최종 결과값이 된다.

그다음, i를 0부터 n-1까지 바꿔가며,
row행 i열에 퀸을 놓을 수 있는지 없는지 검사해가며, 넣을 수 있다면, 다음 row로 넘겨 가면 된다.
재귀함수가 복귀한 후에 다시 놓은 퀸을 회수해 주어야 한다.


Time complexity : O(n^n)
Space complexity : O(n^2)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static boolean[][] a;
	static int n;
	static int count;

	static void calc(int row) {
		if (row >= n) {
			count++;
			return;
		}
		for (int i=0 ; i<n ; i++) {
			a[row][i] = true;
			if (check(row, i))
				calc(row+1);
			a[row][i] = false;
		}
	}

	static boolean check(int i, int j) {
		int k;
		int sumi=0, sumj=0;
		for (k=0 ; k<n ; k++) {
			if (a[i][k]==true)
				sumi++;
			if (a[k][j]==true)
				sumj++;
		}
		if (sumi>1 || sumj>1)
			return false;
		k=1;
		while (i-k>=0 && j-k>=0) {
			if (a[i-k][j-k])
				return false;
			k++;
		}
		k=1;
		while (i-k>=0 && j+k<n) {
			if (a[i-k][j+k])
				return false;
			k++;
		}
		return true;
	}



	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new boolean[n][n];
		count=0;
		calc(0);
		System.out.println(count);
	}
}
