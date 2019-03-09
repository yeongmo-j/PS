"
[문제요약]
N과 B가 주어질 떄, N을 B진법으로 출력해라.
B가 10이 넘을 수 있으므로,
B진법으로 바꿨을 때 , 10=A ~ 25=Z로 출력하면 된다.

[해결방법]
리스트 하나 만들어서
앞에서부터 나머지를 채워나간다.
(지금생각해보니 그냥 log_B(N) 만큼의 배열 만들어도 될듯....)
그중 10 넘는거 알파벳으로 처리해주기


Time complexity : O(log_B(N))
Space complexity : O(log_B(N));

[추가]
"
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static void toBnary(int N, int B) {
		LinkedList<Character> list = new LinkedList<Character>();
		int rest=0;
		while (N!=0) {
			rest = N%B;
			if (rest>=10) {
				list.addFirst((char)(rest-10+'A'));
			}
			else {
				list.addFirst((char)(rest+'0'));
			}
			N/=B;
		}
		for (char c : list) {
			System.out.print(c);
		}
	}


	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int B = scin.nextInt();
		toBnary(N,B);
		scin.close();
	}
}
