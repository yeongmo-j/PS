"
[문제요약]
100 에서 원하는 채널 n으로 이동할 수 있는데 0~9까지 숫자와 채널 +, 채널 - 버튼이 있음
버튼을 최소로 눌러서 n으로 이동하기
근데 0~9중에 몇개가 고장났음.

[해결방법]
1. 채널 이동하는 방법은 숫자버튼을 누르기, +-버튼 누르기, 둘다 섞어서 누르기가 있음
2. 그런데, +- 먼저 누르고 숫자누르는건 의미가 없음 .그러므로 숫자먼저누르고 +- 눌러야 함.
3. 그러므로, 이동하려고 하는 숫자를 정한다음에, 그 수에서 n까지의 거리를 구해주면 된다.
4. 이동하려고 하는 채널이 50만으로 한정되어 있음. 전체 탐색 가능하다
5. 즉, 0~50만까지 모든 수에 대해, 그 수로 버튼을 눌러 이동 할 수 있으면, 버튼을 몇번 눌러야 하는지
구한 다음에, n과의 차이를 더해준 뒤, 이 중 최소값을 구해야 한다
6. 여기서 생각해봐야 할께, 101은, 그냥 + 한번 누르는게 더 빠르다!! 그러므로 초기값을
+, -버튼만 이용해서 가는 경우를 최소로 한다 (n과 100의 차이)
7. 그런데 여기서 또문제. input은 50만으로 한정되어 있지만, 채널은 무한대로 이동이 가능함
즉, 51만으로 버튼 이동했다가 50만으로 -버튼으로 가는게 가능함.
그래서 100만으로 범위를 넓 (0~50만으로 이동하는 거가 최대 = 100만~50만으로 이동하는거)

Time complexity : O(1) ( O(100만*log_10(100만))) )
Space complexity : O(1)

[추가]
이렇게 범위가 좁을 경우엔 다 해보자 
"
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static boolean[] broken;
	static int min;

	static int possible(int channel) {
		if (channel==0) {
			if (broken[0])
				return 0;
			return 1;
		}
		int result = 0;
		while (channel>0) {
			result++;
			if (broken[channel%10]) return 0;
			channel/=10;
		}
		return result;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		broken = new boolean[10];
		if (m!=0) {
			String[] brokens = br.readLine().split(" ");
			for (String brk : brokens)
				broken[Integer.valueOf(brk)] = true;
		}
		min = Math.abs(n-100);
		for (int i=0 ; i<=1000000 ; i++) {
			int len = possible(i);
			if (len>0) {
				int abs = Math.abs(n-i);
				if (min > abs+len)
					min = abs+len;
			}
		}
		System.out.println(min);
	}
}
