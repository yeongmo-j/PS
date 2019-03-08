"
[문제요약]
45656처럼 모든 자리의 수가 인접한 자리의 수와 1 차이가 나는 수를 계단 수라고 한다.
길이가 n인 자리수의 개수를 구하여라

[해결방법]
dp 재귀로 사용
d[i][n] 은 i번째 자리의 수가 n인 가지수
즉 d[i][n] = d[i-1][n-1] + d[i-1][n+1]이다

Time complexity : O(N)
Space complexity : O(1);

[추가]

"
import java.util.Scanner;

class StairNum{
	static long mod = 1000000000;
	long d[][];
	//d[i][n]은 i번째 숫자가 n일 가지수
	StairNum(int n){
		d = new long[n+1][10];
	}
	long run(int i) {
		long result = 0;
		for (int n=0 ; n<=9 ; n++)
			result += go(i,n);
		result%=mod;
		return result;
	}
	long go(int i, int n) {
		if (i==1 && n==0)
			return 0;
		if (i==1)
			return 1;
		if (d[i][n]!=0L)
			return d[i][n];
		if (i-1>=1 && n-1>=0)
			d[i][n]+=go(i-1,n-1);
		if (i-1>=1 && n+1<=9)
			d[i][n]+=go(i-1,n+1);
		d[i][n]%=mod;
		return d[i][n];
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		StairNum stn = new StairNum(n);
		System.out.println(stn.run(n));
		scin.close();
	}
}
