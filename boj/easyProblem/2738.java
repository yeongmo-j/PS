"
[문제요약]
행렬의 덧셈

[해결방법]

Time complexity : O(n*m)
Space complexity : O(n*m)

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
		int m = Integer.parseInt(input[1]);
		int[][] arr = new int[n][m];
		int i, j;
		for (i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<m ; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<m ; j++) {
				arr[i][j] += Integer.parseInt(input[j]);
			}
		}
		for (i=0 ;i<n ; i++) {
			for (j=0 ; j<m ; j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
	}

}
