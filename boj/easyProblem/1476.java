"
[문제요약]
3개의 단위로 날짜를 계산하는데,
1~15 / 1~28 / 1~19 까지가 범위이다 (각 단위 당)
1년 1 1 1
2년 : 2 2 2
...
15년 : 15 15 15
16년 : 1 16 16
이렇게 범위를 넘어서면 1로 바뀐다.

3개의 수가 주어졌을 때, 이는 몇년인가?

[해결방법]
다 해봄.
한바퀴가 다 돌때 : 15,28,19의 최소공배수 일때 : 15,28,19를 다 곱한게 최대루프이다.(충분히 작음)
그래서 각 단위의 수를 구하는 방법
i년이라고 했을 때, i%15가 0이면 15, 아니면 그 값(i%15)가 각 자리의 값이 된다.
이걸 루프 돌려가며 구했을 때, 원래 입력 받은 수와 같은지 확인


Time complexity : O(1) (15*28*19)
Space complexity : O(1)

[추가]
자리수 범위 넘어갈때 계산하기 쉬운 방법 :
그냥 각 자리수 다 1부터 1씩 증가시킨 다음에,
만약에 15가 되면 그떄 1로 만들어 준다.
e += 1;
s += 1;
m += 1;
if (e == 16) {
    e = 1;
}
if (s == 29) {
    s = 1;
}
if (m == 20) {
    m = 1;
}
이렇게


@@@@@추가@@@@@@
이걸 범위를 1씩 앞으로 땡겨주면,0<=e<15
이렇게,
그렇게 되면, i%15 = e
i%28 = s
i%19 = m
이 되고 , 각 e,s,m을 대입받은 수에 넣어주면
가장 작은 i를 구하는 중국인의 나머지 정리 문제가 된다 <<<

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int e = Integer.parseInt(in[0]);
		int s = Integer.parseInt(in[1]);
		int m = Integer.parseInt(in[2]);
		int i;
		for (i=1 ; i<15*28*19 ; i++) {
			int ee = i%15==0 ? 15 : i%15;
			int ss = i%28==0 ? 28 : i%28;
			int mm = i%19==0 ? 19 : i%19;
			if (ee==e && ss==s && mm==m) {
				break;
			}
		}
		System.out.println(i);
	}
}
