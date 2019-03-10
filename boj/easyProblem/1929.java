"
[문제요약]
N~M사이의 숫자 중에 소수 찾기

[해결방법]
에라토스테네스의 체

Time complexity : O(NlglgN)
Space complexity : O(N)

[추가]
@@@@@
에라토스테네스의 체에서
왜 i*i부터 지우기 시작하는지, (또 i*i를 하지 말아야 할 경우는 어떤것이 있는지 : 오버플로우 막기 위해)
또 시간복잡도는 O(N*lglgN) 이라는것 알아두기.(강의자료에 있다)

"

import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int M = scin.nextInt();
		int N = scin.nextInt();
		int[] prime = new int[N+1];
		for (int i=2 ; i<=N ; i++) {
			if (i>=M && prime[i]!=1) {
				System.out.println(i);
			}
			for (int j=2 ; j*i<=N ; j++ ) {
				prime[j*i]=1;
			}
		}
		scin.close();
	}
}
