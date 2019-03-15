"
[문제요약]
A, P가 들어오고
D[1] = A
D[N] = D[N-1]의 각 자리수의 p승을 더한 수 일 때,
계속 D를 확장해 나가면, 언젠가는 원래 나왔던 수가 나온다(루프가 생긴다)
이때 루프를 제외한 그 앞부분의 수는 몇개인가?


[해결방법]
배열 잡아놓고 arr[i]는 i가 몇번째 순서에 등장하는지를 기록해놓는다.
arr[i]가 이미 존재하면, 그 수를 통해 정답을 낸다.

Time complexity : O(1) 한 루프당 5자리의 5승이라고 하면, 25 * 백만 = 2천5백만이 최대이다.
Space complexity : O(1) 백만

[추가]
arr를 왜 백만만 잡아도 되는가?
시간복잡도는?


"

import java.util.*;

public class Main {

	static int exp(int a, int b) {
		//return a^b;
		int result = 1;
		for (int i=0 ; i<b ; i++) {
			result *= a;
		}
		return result;
	}

	static int next(int now, int b) {
		int result = 0;
		while (now>0) {
			result += exp(now%10, b);
			now/=10;
		}
		return result;
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int A = scin.nextInt();
		int P = scin.nextInt();
		int[] arr = new int[1000000];
		//arr[i]는 i를 몇번째에 방문했는 저장해둠.
		int count=0;
		while(arr[A]==0) {
			arr[A] = ++count;
			A = next(A, P);
		}
		System.out.println(arr[A]-1);
		scin.close();
	}
}
