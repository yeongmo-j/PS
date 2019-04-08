"
[문제요약]
별찍기


[해결방법]
분할정복

Time complexity : O(N^2) (총 칸의 수가 N*(2*N-1)개인데, 최대 한칸씩 칠한다)
Space complexity : O(1)

[추가]

""

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static char[][] arr;
	static void star(int istart, int jstart, int n) {
		if (n<=3) {
			arr[istart][jstart+2] = '*';
			arr[istart+1][jstart+1] = '*';
			arr[istart+1][jstart+3] = '*';
			for (int i=0 ; i<5 ; i++)
				arr[istart+2][jstart+i] = '*';
			return;
		}
		else {
			star(istart+n/2, jstart, n/2);
			star(istart+n/2, jstart+n, n/2);
			star(istart, jstart+n/2, n/2);
			return;
		}
	}



	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		arr = new char[N][2*N-1];
		star(0,0,N);
		StringBuilder str = new StringBuilder();
		for (char[] row : arr) {
			for (char elem : row) {
				if (elem=='*')
					str.append('*');
				else
					str.append(' ');
			}
			str.append('\n');
		}
		System.out.println(str);
	}
}
