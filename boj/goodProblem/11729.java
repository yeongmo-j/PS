"
[문제요약]
하노이 탑 문제

[해결방법]
재귀

Time complexity : O(2^N)
Space complexity : O(N) 스택의 높이?

[추가]
하노이탑의 시간복잡도 구하기
dp로 구해보자
d[i] 는 i개의 탑을 원하는 곳에 보내는데 걸리는 시간이라고 하면
d[i] = d[i-1]개를 임시장소에 옮기고 + i번째 원판 제대로 옮기고 + d[i-1]개를 그 위에 쌓는게 된다
즉, 점화식이 d[i] = 2d[i-1] +1이 된다.
T(i) = 2^i -1이 된다.

또 2^i-1 구하는법
System.out.println((1<<n)-1);

이것때문에 좋은문제에 넣음.


"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static StringBuilder str;
	static int count;


	static void hanoii(int N, int from, int to) {
		if (N==1) {
			str.append(from + " " + to + "\n");
			count++;
			return;
		}
		hanoii(N-1, from, 6-from-to);
		str.append(from + " " + to + "\n");
		count++;
		hanoii(N-1, 6-from-to, to);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		str = new StringBuilder();
		count=0;
		hanoii(N,1,3);
		System.out.println(count);
		System.out.print(str);
	}
}
