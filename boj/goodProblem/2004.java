"
[문제요약]
nCm을 계산했을 때 맨뒤에 0이 몇번 나오는지?

[해결방법]
팩토리알이랑 똑같이 10이 몇번 곱해지는지, 즉 그 소인수분해한 값인 2와 5가 몇번 나오는지를 살펴보면 되는데
이건 팩토리얼과 다르게, n!/m!(n-m)!로 나눠지는 값이 있기 때문에
2와 5를 각각 세줘야 한다.

N에 2가 몇번 나오는지 아는 법 :
N을 2로 나눈 값을 더해준다 -> 2가 나온 갯수
N을 4로 나눈 값을 더해준다 -> 아까 2로 나눈것들은 2 한번만셌고 , 4는 2가 2번 들어가기때문에 한번씩 더더해줌
for (i=2 ; i<=n ; i*=2) {
  two+=n/i;
}
이걸 n에 대해 구해주고, m에 대해 구한값과 n-m에 대해 구한 값들을 빼주면 된다!

Time complexity : O(lgN) : N개를 루프 돌리는데 각 수는 log_5(N)보다 적게 while루프돈다.
Space complexity : O(1)

[추가]
문제 1676과 연계도는 문제임.

"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int m = scin.nextInt();

		//2의 배수의 개수 세는법, 4의 배수의 개수 세는법 잘 알아둘 것
		long two=0;
		long five=0;
		long i;
		for (i=2 ; i<=n ; i*=2) {
			two+=n/i;
		}
		for (i=5 ; i<=n ; i*=5) {
			five+=n/i;
		}
		for (i=2 ; i<=m ; i*=2) {
			two-=m/i;
		}
		for (i=5 ; i<=m ; i*=5) {
			five-=m/i;
		}
		for (i=2 ; i<=n-m ; i*=2) {
			two-=(n-m)/i;
		}
		for (i=5 ; i<=n-m ; i*=5) {
			five-=(n-m)/i;
		}
		System.out.println(Math.min(two, five));


		scin.close();
	}
}
