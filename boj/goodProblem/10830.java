"
[문제요약]
행렬 a의 b제곱

[해결방법]
정수의 b제곱 구하는 거와 마찬가지로
반으로 나눠서 분할정복!

Time complexity : O(n^3*lgb)
Space complexity : O(lgb*n^3)

[추가]

"


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;

	static int[][] multi(int[][]a, int[][]b){
		//a*b
		int[][] result = new int[n][n];
		int i, j, k;
		for (i=0 ; i<n ; i++) {
			for (j=0 ; j<n ; j++) {
				int sum=0;
				for (k=0 ; k<n ; k++)
					sum=sum+(a[i][k]*b[k][j])%1000;
				result[i][j] = sum%1000;
			}
		}
		return result;
	}

	static int[][] expon(int[][]a, long b){
		//a^b
		if (b==1) {
			return a;
		}
		else if (b%2==0) {
			int[][] x = expon(a, b/2);
			return multi(x, x);
		} else {
			int[][] x = expon(a, (b-1)/2);
			return multi(multi(x, x), a);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		long b = Long.parseLong(input[1]);
		int[][] arr = new int[n][n];
		int i, j;
		for (i=0 ; i<n ; i++) {
			input = br.readLine().split(" ");
			for (j=0 ; j<n ; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		//입력완료
		int[][] result = expon(arr, b);
		//연산완료
		for (i=0 ; i<n ; i++) {
			for (j=0 ; j<n ; j++) {
				System.out.printf("%d ", result[i][j]%1000);
			}
			System.out.println();
		}
	}
}
