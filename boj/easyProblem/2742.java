"
[문제요약]
N부터 1까지 찍기

[해결방법]


Time complexity : O(N)
Space complexity : O(1);

[추가]
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		while (N>0) {
			System.out.println(N);
			N--;
		}
		scin.close();
	}
}
