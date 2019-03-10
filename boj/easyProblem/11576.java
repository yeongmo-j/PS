"
[문제요약]
A진수를 B진수로 바꾸기

[해결방법]
A진수 -> 10진수 -> B진수


Time complexity : O(log_B(10^m)) : 로그의 밑은 B, 위는 A를 10진수로 바꾼 크기
Space complexity : O(log_B(10^m)); 배열의 크기

[추가]

"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int A = scin.nextInt();
		int B = scin.nextInt();
		int m = scin.nextInt();
		int result = 0;
		while (--m>=0) {
			result *= A;
			result += scin.nextInt();
		}
		if (result==0) {
			System.out.print(0);
		}
		else {
			int[] arr = new int[(int)(Math.log(result)/Math.log(B))+1];
			int idx = 0;
			while (result!=0) {
				 arr[idx++]=result%B;
				 result/=B;
			}
			for (int i=idx-1; i>=0 ; i--) {
				System.out.printf("%d ",arr[i]);
			}
		}

		scin.close();
	}
}
