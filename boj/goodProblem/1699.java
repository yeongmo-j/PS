"
[문제요약]
11=3^2+1^2+1^2 처럼 제곱수의 3개 항의 합으로 나타낼 수 있다.
이렇게 숫자 n이 입력으로 들어올 때, 이를 제곱수의 합으로 나타내는데, 그 항의 수가 제일 적은 경우의 항의
 수를 출력하라.

[해결방법]
dp bottom up으로 풀었다.
d[i] 는 i를 제곱수의 합으로 나타낼 때, 그 항의 수의 최소의 값
i를 나타낼 때, ㅁ + j^2 = i 처럼 j의 제곱을 하나 떼고 생각해 본다.
그렇게 되면 d[i] = d[i-j^2]+1이 된다!!
여기서 j의 범위는 1부터 루트i까지이다.
for (i=2 ; i<=n ; i++) {
  d[i] = Integer.MAX_VALUE;
  for (j=1 ; j<=(int)Math.sqrt(i) ; j++) {
    d[i] = Math.min(d[i], d[i-j*j]+1);
  }
}
즉 이렇게 되는 것임.
시간의 복잡도는 n개 * 루트n개이다. (j의 범위가 루트이므로 )

Time complexity : O(N*rootN)
Space complexity : O(N);

[추가]
@@@@
d[i] = Integer.MAX_VALUE;
로 초기화를 할 떄, 어차피 최대값은 다 1의 제곱으로 표현한 i가 최대이므로,
d[i] = i 로 초기화 하는게 더 좋을것 같다.

@@@@@@@@@@@@@@@@@@@@@@
그리고 루프 돌릴 때, for (j=1 ; j*j<=i ; j++)
로 돌리는게 더 좋다!!!!!!!!!
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int i, j;
		int[] d = new int[n+1];
		d[1]=1;

		for (i=2 ; i<=n ; i++) {
			d[i] = Integer.MAX_VALUE;
			for (j=1 ; j<=(int)Math.sqrt(i) ; j++) {
				d[i] = Math.min(d[i], d[i-j*j]+1);
			}
		}
		System.out.println(d[n]);
		scin.close();
	}
}
