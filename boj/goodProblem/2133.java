"
[문제요약]
3*n 크기를  크기2짜리 타일로 가득 채우는 방법의 수

[해결방법]
타일을 채우는 방법을 잘 생각해 보자.
일단 세로가 3이기 때문에, 맨위나 맨아래줄에는 ㅁㅁ 모양 타일이 꼭 들어가야 한다
즉
ㅡㅡ
ㅣㅣ
ㅣㅣ 이모양이 상하반전 2개,

ㅡㅡ
ㅡㅡ
ㅡㅡ 이모양이 하나
가 들어갈 수 있다.

d[i]= d[i-2]*3이 되는 것이다.
여기에, 또 새로운 모양이 들어갈 수 있다.
ㅡㅡ ㅡㅡ
ㅣㅡ ㅡㅣ
ㅣㅡ ㅡㅣ
이모양과
ㅡㅡ ㅡㅡ ㅡㅡ
ㅣㅡㅡ ㅡㅡ ㅣ
ㅣㅡㅡ ㅡㅡ ㅣ
이모양 처럼 점점 2씩 늘려가며 가운데를 늘려갈 수 있다!
즉 d[i]+=d[i-2*j]*2 로 더해줘야 한다.
j는 2부터 시작하여 i-2*j가 0이 될때까지이다.

d[0] = 1;

for (i=2 ; i<=n ; i++) {
  if (i%2!=0)
    continue;
  d[i] = d[i-2]*3;
  for (j=2 ; j*2<=i ; j++) {
    d[i]+=2*d[i-j*2];
  }
}

결론은 이렇게 나온다.

Time complexity : O(N)
Space complexity : O(N);

[추가]

"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int i, j;
		int[] d = new int[n+1];
		d[0] = 1;

		for (i=2 ; i<=n ; i++) {
			if (i%2!=0)
				continue;
			d[i] = d[i-2]*3;
			for (j=2 ; j*2<=i ; j++) {
				d[i]+=2*d[i-j*2];
			}
		}

		System.out.println(d[n]);
		scin.close();
	}
}
