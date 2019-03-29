"
[문제요약]
나무N개가 일렬로 늘어서있고,
나무 커팅기로 높이 x로 맞추고 잘랐을 때, 잘리게 되는 나무의 윗부분을 집에 가져갈꺼다.
그 윗부분들의 합이 M 이상이여야 할 때, x의 최대값은? (나무를 최대한 조금자를꺼임)

[해결방법]
어떤 값을 넣어 yes/no로 판별이 가능하다 & 최대값 구한다 -> 이분탐색

판별방법 : 각 원소에서 x빼고, 그 값이 0 이상이면 그 값들을 더해서 M보다 큰지 확인해준다.

처음 left : 0 (높이다 0이니까, 다가져가는거) 처음 right : 최대값 : (아무것도 안가져가는거)
이렇게 놓고 이분탐색을 해준다.

만약 가운데점이 가능하면, 그 값을 저장해두고, 그 저장해둔 값중에 최대값을 출력해준다.


Time complexity : O(N * lg(높이))
Space complexity : O(N)

[추가]
이분탐색 : 신경써줘야 할 것이 많다
Yes / no로 나눠지는지?
검증하는 방법은?

"

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] arr;
	static int N;
	static int M;

	static boolean check(int m) {
		long ans = 0;
		for (int i=0 ; i<N ; i++) {
			if (arr[i]-m>0) {
				ans += arr[i]-m;
			}
		}
		return ans>=M;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		N = Integer.valueOf(in[0]);
		M = Integer.valueOf(in[1]);
		arr = new int[N];
		int i;
		int left = 0;
		int right = Integer.MIN_VALUE;
		String[] temp = br.readLine().split(" ");
		for (i=0 ; i<N ; i++) {
			arr[i] = Integer.valueOf(temp[i]);
			right = Integer.max(arr[i], right);
		}
		int answer = 0;
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
