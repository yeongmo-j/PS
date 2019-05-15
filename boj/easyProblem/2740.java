"
[문제요약]
행렬의 곱셈
n*m 짜리와 m*k짜리를 곱하자

[해결방법]

Time complexity : O(n*m*k)
Space complexity : O(n*m + m*k)

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
		int i, j, l;
		for (i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<m ; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		input = br.readLine().split(" ");
		int k = Integer.parseInt(input[1]);
		int[][] arr2 = new int[m][k];
		for (i=0 ; i<m ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<k ; j++) {
				arr2[i][j] += Integer.parseInt(input[j]);
			}
		}
		int[][] result = new int[n][k];
		for (i=0 ; i<n ; i++) {
			for (j=0 ; j<k ; j++){
				int sum = 0;
				for (l=0 ; l<m ; l++)
					sum+=arr[i][l]*arr2[l][j];
				result[i][j] = sum;
			}
		}
		for (i=0 ; i<n ; i++) {
			for (j=0 ; j<k ; j++) {
				System.out.printf("%d ", result[i][j]);
			}
			System.out.println();
		}
	}

}
