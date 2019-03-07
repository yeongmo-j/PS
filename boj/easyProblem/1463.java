"
[문제요약]
N이 3으로 나눠떨어지면 3으로 나눠
N이 2로 나눠떨어지면 2로 나눠
1을 빼
이렇게 연산 한번씩 해가며 1로 만들 때,
연산 최대한 적게 쓰는 방법은?


[해결방법]
각 연산 한번씩 해가며 배열에 현재 인덱스까지 몇번 연산 했는지 저장해가며, 최소값 저장
배열의 인덱스 1의 값을 출력.


Time complexity : O(N) : 배열 N개, 각 재귀 당 O(1)
Space complexity : O(1);

[추가]

dp를 사용 할 때, cache의 정의를 잘 세우자.
나는 n에서 연산을 최소로 사용해서 k로 갈 때의 연산의 수를 d[k]로 했는데,
k에서 연산을 최소로 사용해서 1로 갈때의 연산의 수를 d[k]로 하는 것이 더욱 간편하고 좋다.

class One{
	int[] d;
	//d[n]은 n을 1로 만들 때 필요한 연산의 수.
	One(){}
	One(int n){
		d = new int[n+1];
	}
	int go(int n) {
		if (n==1)
			return 0;
		if (d[n]>0)
			return d[n];
		d[n] = go(n-1)+1;
		if (n%2==0) {
			int temp = go(n/2)+1;
			if (temp<d[n])
				d[n] = temp;
		}
		if (n%3==0) {
			int temp = go(n/3)+1;
			if (temp<d[n])
				d[n] = temp;
		}
		return d[n];
	}
}

"
import java.util.Scanner;

class One{
	int[] dp;
	int n;
	One() {}
	One(int n){
		this.n = n;
		dp = new int[n+1];
	}
	void run(int n, int count) {
		if (n<=0)
			return;
		if (dp[n]!=0 && count>dp[n])
			return;
		dp[n] = count;
		if (n%3==0)
			run(n/3, count+1);
		if (n%2==0)
			run(n/2, count+1);
		run(n-1, count+1);
	}
}
public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		One one = new One(N);
		one.run(N, 0);
		System.out.println(one.dp[1]);

		scin.close();
	}
}
