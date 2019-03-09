"
[문제요약]
숫자가 여러개 들어오고, 둘씩 짝지어서 가능한 GCD의 총 합을 구하여라.

[해결방법]
둘찍 짝짓고 유클리드 호제법 이용

Time complexity : O(N^2*lg(min(a+b)))
Space complexity : O(lg(min(a+b))) 재귀의 크기

[추가]
백준 수학 1 확인
"
import java.util.Scanner;

public class Main {

	static int GCD(int a, int b) {
		if (b==0)
			return a;
		else
			return GCD(b, a%b);
	}


	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int t =scin.nextInt();
		while (--t>=0) {
			int n = scin.nextInt();
			long result = 0;
			int[] arr = new int[n];
			int i,j;
			for (i=0 ; i<n ; i++)
				arr[i] = scin.nextInt();
			for (i=0 ; i<n-1 ; i++) {
				for (j=i+1 ; j<n ; j++) {
					result += GCD(arr[i], arr[j]);
				}
			}
			System.out.println(result);
		}
		scin.close();
	}
}
