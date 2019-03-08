"
[문제요약]
2*n배열로 점수들이 들어온다.
스티커의 배열인데
스티커들이 너무 후져서 하나를 고르면, 맞닿아있는 스티커들은 못씀.
그래서 스티커를 여러게 떼어냈을 떄, 그 점수의 합중 최대값을 구하여라.
즉 하나를 뗴면, 그 양옆위아래꺼는 못쓰고 다음 스티커를 뜯어야 한다.

[해결방법]
d[i][L] : i번쨰줄의 스티커를 하나 L의 case로 뜯었을 때 얻을 수 있는 최대 점수
case L은 다음과 같이 정의한다. 1)아무것도 안똄
2) 위에꺼만 뗌
3) 아래꺼만 뗌 (2줄이기 때문에 이게 다임 )
이렇게 정의 한 후 DP bottom up으로 실행

점수 배열은 A로 들어 있다(2*n)

d[i][0] : i번째줄 스티커 하나도 안떼었을 때 :max{d[i-1][0], d[i-1][1], d[i-1][2]}
d[i][1] : i번째줄 스티커 위에꺼 떼었을 때 : max{d[i-1][0], d[i-1][2]} + A[0][i];
d[i][2] : i번째줄 스티커 아래꺼 뗴었을 때 : max{d[i-1][0], d[i-1][1]} + A[1][i];

이렇게 i를 2부터 n까지 루프 돌린 뒤 d[n][0~2]중 제일 큰거 반환
(d[1][0,1,2]는 0, A[0][1], A[1][1]로 초기화 되어 있음)


Time complexity : O(N)
Space complexity : O(1);

[추가]
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int T = scin.nextInt();
		while (--T>=0) {
			int n = scin.nextInt();
			int[][] A = new int[2][n+1];
			int i, j;
			for (i=0 ; i<2 ; i++) {
				for (j=1 ; j<n+1 ; j++) {
					A[i][j] = scin.nextInt();
				}
			}
			int[][] d = new int[n+1][3];
			//d[i][L]은 i번째 스티커를 L타입으로 뜯을 떄의 점수의 합
			d[1][0] = 0;
			d[1][1] = A[0][1];
			d[1][2] = A[1][1];
			for (i=2 ; i<=n ; i++) {
				d[i][0] = Integer.max(d[i-1][0], Integer.max(d[i-1][1], d[i-1][2]));
				d[i][1] = Integer.max(d[i-1][0], d[i-1][2]) + A[0][i];
				d[i][2] = Integer.max(d[i-1][0], d[i-1][1]) + A[1][i];
			}
			int result = Integer.max(Integer.max(d[n][0],d[n][1]),d[n][2]);
			System.out.println(result);
		}
		scin.close();
	}
}
