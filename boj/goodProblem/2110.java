"
[문제요약]
집 N개가 수직선 위에 있고 (X1~XN)
각 좌표가 주어진다.

공유기 C개를 설치하는데,
최대한 멀리 떨어틀여 설치하고 싶다.
이 때, 공유기 설치할 때, 가장 가까운 공유기의 거리가 최대가 되게 해라. (최대한 분산되게)
그 거리 값을 출력

[해결방법]
일단 그 가까이 있는 공유기의 거리가 x일 때, c개를 설치할 수 있는지를 판별 할 수 있다!!
c개가 넘어도 된다. (왜냐면 c개 이후로는ㄴ 설치 안하면 되므로 )

그러니까, 그 거리를 구하기 위해서
거리를 계속 대입해서 yes/no로 판별 해주면 된다!
->이분 탐색

yes/no판별 하는 법. 인접한 공유기의 최소거리를 m이라 한다.
이말은 즉 공유기를 설치할 때, 인접한거보다 m 이상 떨어져야 한다는 말임
일단 1번에는설치를 한다
그다음 2번을 살펴보는데, 1번과 좌표 차가 m이상이면 설치하고(개수세주고) 1번을 기록한다(마지막공유기)
이렇게 2번부터 N번까지, 마지막으로 설치된 공유기와 m이상 차이나는지 확인하고 개수 세준다.
이 개수가 c를 넘으면 yes 이다.

이제 이분탐색을 위한 left = 1이다. 모든집은 1이상 떨어져있다.

right는 원소를 정렬 했을 때, XN-X1이다.

이제 이분탐색을 해주면 된다.
m=(right+left)/2로, m을 시뮬레이션 해봐서 성공하면 그 값 기록. & left = right+1
안되면 right=m-1
그 값 기록된거중에 제일 큰값 출력.


Time complexity : O(N * lg(집의최대거리차이) + NlgN) :정렬하는거까지
Space complexity : O(N)

[추가]
절대 이분탐색 문제라고 생각하지 못했는ㅔㄷ

어떤 수를 대입했을 때, 판별 가능 했다!!!!!
이 아이디어 너무 신기함 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


이분탐색 : 신경써줘야 할 것이 많다
Yes / no로 나눠지는지?
검증하는 방법은?

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int[] arr;
	static int N;
	static int C;

	static boolean check(int m) {
		int count = 1;
		int last = 0;
		for (int i=1 ; i<N ; i++) {
			if (arr[i]-arr[last]>=m) {
				count++;
				last = i;
			}
		}
		return count>=C;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		N = Integer.valueOf(in[0]);
		C= Integer.valueOf(in[1]);
		arr = new int[N];
		int i;
		int left = 1;
		for (i=0 ; i<N ; i++)
			arr[i] = Integer.valueOf(br.readLine());
		Arrays.sort(arr);
		int right = arr[N-1]-arr[0];
		int answer = 1;
		while (left<=right) {
			int m = (left+right)/2;
			if (check(m)) {
				answer = Integer.max(answer, m);
				left = m+1;
			} else
				right = m-1;
		}
		System.out.println(answer);
	}
}
