"
[문제요약]
파도반 수열 (문제 확인하자 그림임 )

[해결방법]
점화식을 세워보면 			d[i] = d[i-1]+d[i-5];
임을 알 수 있음.
어차피 100번밖에 안걸리니까 다 구해놓고
결과만 하나씩 출력
@@@@@@ 자료형은 long으로 해야 오류가 나질 않음!!!@@@@@@@@@

Time complexity : O(N) (or O(1))
Space complexity : O(N);

[추가]

d[i] = d[i-2]+d[i-3]이라는 점화식도 가능 함 .

"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int T = scin.nextInt();
		int i, j;
		long[] d = new long[101];
		d[1]=1;
		d[2]=1;
		d[3]=1;
		d[4]=2;
		d[5]=2;
		for (i=6 ; i<=100 ; i++) {
			d[i] = d[i-1]+d[i-5];
		}
		while (--T>=0) {
			int n = scin.nextInt();
			System.out.println(d[n]);
		}
		scin.close();
	}
}
