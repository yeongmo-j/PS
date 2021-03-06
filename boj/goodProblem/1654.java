"
[문제요약]
K개의 랜선이 있음
N개의 랜선으로 만들고 싶은데
저 K개의 랜선의 길이는 다 제각각이라
거기서 조각내서 그걸 N개로 만들어야 함

만들 수 있는 랜선 조각의 최대 길이를 구하여라
즉 K개의 랜선을 길이 x씩 조각내서 N개를 만들어야 하는데 그 x의 최대값을 구하여라.

[해결방법]
이분탐색 : x가 가능한지 안가능한지 순차적으로 알아볼 수 있을 떄!
정답을 구하는 문제 <-> 가능한지 살펴보는 문제로 변환 가능 함
1 가능 2 가능 3 불가능 하면 2가 정답(최대값)
이런식으로

                                                                                                                                                           어떤 기준을 잡고 Yes/No로 판별 가능하면 구할 수 있다.

그렇다면 판별하는법 :
K개의 랜선을 각각 루프 돌리며 x로 나눠본다.
만약 그 나눈 몫들의 합이 N 이상이면 성공인 것이다.

이때 이 x의 '최대값' 은?
이분탐색으로 구할 수 있다.
일딴 좌측을 뜻하는 l과, 우측을 뜻하는 r을 변수로 삼고, 이를 자를 길이라고 하자.
초기에, l은 1이다.(무조건 정답은 있기때문에)
초기에, r은 원소 중 최대 값이다.
이제, l<=r일 동안,
m=(l+r)/2로 구해놓고 , m에대해 판별한다.
m이 성공하면 , 그 m을 저장하고 , r을 m-1로 옮긴다.
이때, 이 성공한 값중에 제일 최대값만 저장해놓으면 된다.

Time complexity : O(K * lg(max길이))
Space complexity : O(K)

[추가]
이분탐색 : 신경써줘야 할 것이 많다
Yes / no로 나눠지는지?
검증하는 방법은?


"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	static long[] arr;
	static int K;
	static int N;

	static boolean check(long mid) {
		long result = 0;
		for (int i=0 ;  i<K ; i++) {
			result += arr[i]/mid;
		}
		if (result>=N)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		K = Integer.valueOf(in[0]);
		N = Integer.valueOf(in[1]);
		arr = new long[K];
		int i;
		long left = 1;
		long right = Integer.MIN_VALUE;
		for (i=0 ; i<K ; i++) {
			arr[i] = Long.valueOf(br.readLine());
			right = Long.max(arr[i], right);
		}
		long answer = 1;
		while (left<=right) {
			Long m = (left+right)/2;
			if (check(m)) {
				answer = Long.max(answer, m);
				left = m+1;
			} else
				right = m-1;
		}
		System.out.println(answer);
	}
}
