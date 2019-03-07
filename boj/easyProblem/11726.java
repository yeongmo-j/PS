"
[문제요약]
직사각형 채우기. 2*N의 넓이에, 넓이 2인 직사각형을 가로, 세로로 배치해여 채우는 가지의 수

[해결방법]
DP 이용. 세로로 하나 채우면 한칸 줄어들고, 가로로 한칸 채우면 두칸 줄어든다.
dp[n] = dp[n-1]+dp[n-2];

Time complexity : O(N)
Space complexity : O(1);

[추가]

"
import java.util.Scanner;

class Rectangle {
	long[] d;
	int max;
	//d[k]는 2*k크기의 직사각형을 채우는 방법의 수
	Rectangle(int n){
		d = new long[n+1];
		max = n;
	}
	long fill(int n) {
		if (n<=1)
			return 1;
		if (d[n]!=0)
			return d[n];
		d[n] = (fill(n-1)+fill(n-2))%10007;
		return d[n];
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		Rectangle rec = new Rectangle(N);
		System.out.println(rec.fill(N)%10007);
		scin.close();
	}
}
