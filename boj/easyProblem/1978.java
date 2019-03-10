"
[문제요약]
n개의 수 중에서 소수 개수 찾기

[해결방법]

Time complexity : O(n*1) : n개의 수 , 1000이하니까 1
Space complexity : O(1);

[추가]
왜 루트n까지만 찾아도 되는지 pdf 참조
"
import java.util.Scanner;

public class Main {

	static boolean prime(int n) {
		if (n<2)
			return false;
		for (int i=2 ; i*i<=n ; i++) {
			if (n%i==0)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int count=0;
		while (--N>=0) {
			if (prime(scin.nextInt()))
				count++;
		}
		System.out.println(count);
		scin.close();
	}
}
