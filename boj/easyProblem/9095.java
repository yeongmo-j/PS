"
[문제요약]
n을 1,2,3의 합으로 표현할 수 있는 가지의 수.

[해결방법]
dp 재귀로 사용
d[k]는 k를 1,2,3으로 표현할 수 있는 방법의 수로 정의
d[k] = go(n-1) + go(n-2) + go(n-3)

Time complexity : O(N)
Space complexity : O(1);

[추가]
경계조건을 정하는 것이 너무 어렵다.
n이 0,1일 때는 1이고
그 이하일 때는 0이여야 하는데.. 왜?
그 이하일 때는, 그 수를 만들 수가 없으니까?
만약 0이라면, 바로 1,2,3을 만들 수 가 있다.
만약 1이라면 1부터 시작할 수 있다.
하지만 -1이라면?

해설을 봤더니,
int[] d = new int[11];
d[0] = 1;
for (int i=1; i<=10; i++) {
    for (int j=1; j<=3; j++) {
        if (i-j >= 0) {
            d[i] += d[i-j];
        }
    }
}

이렇게도 구할 수 있다.
0부터 시작해서, 1~3범위 안으로 계속 쌓아올린다.


"

import java.util.Scanner;

class Sum{
	int[] d;
	//d[n]은 d[n]을 1, 2, 3의 조합으로 나타내는 방법의 수
	Sum(int n){
		d = new int[n+1];
	}
	int run(int n) {
		if (n==1 || n==0)
			return 1;
		if (n<0)
			return 0;
		if (d[n]>0)
			return d[n];
		d[n] = run(n-1)+run(n-2)+run(n-3);
		return d[n];
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int T = scin.nextInt();
		while (--T>=0) {
			int N = scin.nextInt();
			Sum sum = new Sum(N);
			System.out.println(sum.run(N));

		}
		scin.close();
	}
}
