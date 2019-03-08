"
[문제요약]
이진수를 만드는데, 1이 연속으로 2번이상 나올 수는 없다.
맨앞은 0이면 안됨.
n자리로 만들 때 몇개 나옴?

[해결방법]
dp 재귀로 사용
d[n]은 n자리 이친수의 가지수
n번째 자리의 숫자가 0일 경우, 그 앞에 올 수 있는 수는 1,0 둘다 가능 하다 : d[n-1]
n번째 자리의 숫자가 1일 경우, 그 앞에 올 수 있는 수는 0이고, 그 앞에 올수 있는 수는 1,0이다 : d[n-2]
그래서 d[n] = d[n-1] + d[n-2]로 구할 수 있다.

d[1] = 1이고
d[2] = 1이다.


Time complexity : O(N)
Space complexity : O(1);

[추가]
int 범위 때문에 틀렸다고 나온다. 범위 잘 살펴 볼 것.


@@@또 다른 방법@@@@
d[i][n]을 새로 정의해 보자.
d[i][n] = i번째 자리의 수가 n일 경우의 수.

n에는 0과 1이 올 수가 있다.
d[i][0] = d[i-1][0] + d[i-1][1]
d[i][1] = d[i-1][0]
이렇게 점화식을 세울 수 있고,

다 구한 뒤에, 정답은 d[n][0] + d[n][1]가 된다.

"
import java.util.Scanner;

class Prinary{
	long d[];
	Prinary(int n){
		d = new long[n+1];
	}
	long go(int n) {
		if (n<=2)
			return 1;
		if (d[n]!=0)
			return d[n];
		d[n] = go(n-1) + go(n-2);
		return d[n];
	}
}



public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		Prinary pri = new Prinary(n);
		System.out.println(pri.go(n));
		scin.close();
	}
}
