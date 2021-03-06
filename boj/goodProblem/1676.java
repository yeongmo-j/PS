"
[문제요약]
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
즉 10! =               3628800 에서 정답은 2이다.

[해결방법]
일단 뒤에 0이 붙는단거는 10이 곱해진단 거다.
그러므로 N!을 10으로 몇번 나눌 수 있냐 : 2*5가 소인수분해 했을 때 몇개 들어 있냐
즉 1,2,3,4 ,,, N을 소인수 분해 해서 2와 5의 수를 세주면 된다.
그런데 중요한 점은
5보다 2가 훨씬 많이 나온다는 점.. 그러므로 5가 몇번이나 나오나 세보면 된다.
@@@@@@@@@@@@
5 한번만 나눠보는게 아니라
그 N까지의 곱해주는 수 중에 소인수분해 했을때 5가 @몇개@ 나오는지 계속해서 나눠줘야 한다.

Time complexity : O(Nlog_5(N)) : N개를 루프 돌리는데 각 수는 log_5(N)보다 적게 while루프돈다.
Space complexity : O(1)

[추가]
for (int i=5; i<=n; i*=5) {
		ans += n/i;
}

이렇게 구하면 된다!!!!!!!!!!
그냥 5 한번 나오는거 한번씩 더해주고
25로 나눠서 두번나오느거 한번씩 더더해주고
125로 나눠서 세번나오는거 한번씩 더더해주고 
"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int five = 0;
		for (int i=1 ; i<=N ; i++) {
			if (i%5==0) {
				int j= i;
				while (j%5==0) {
					five++;
					j/=5;
				}
			}
		}
		System.out.println(five);

		scin.close();
	}
}
