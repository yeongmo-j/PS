"
[문제요약]
히스토그램 들어오고 직사각형 가장 넓은 넓이 찾기

[해결방법]
분할정복
왼쪽, 오른족에서 찾아주고
중간에 걸치는거 찾아서 3개중에 제일 큰거 리턴.
걸치는거 찾아줄 때, 가운데 2개로 시작해야함(최소 이 중간에 2개를 포함해야 중간에 걸치는 문제임.
한쪾에만 있는거면 이미 분할과정에서 다 풀려있어서 고려할필요 없음)
그다음에 양쪽으로 한칸씩 늘려주면 된다(더 큰거 골라서)

Time complexity : O(nlgn) T(n) = 2T(n/2) + theta(n)
Space complexity : O(lgn + n) 스택 + 배열

[추가]

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] rect;

	static long maxRect(int p, int q) {
		if (p>q)
			return 0;
		if (p==q)
			return rect[p];
		int r = (p+q)/2;
		long left = maxRect(p, r);
		long right = maxRect(r+1, q);
		long mid = 0;

		if (r+1<=q) {
			//le는 왼쪽경계, ri는 오른쪽경계
			int le = r;
			int ri = r+1;
			//최소높이
			int height = Integer.min(rect[le], rect[ri]);
			//밑변길이
			long length=2;
			mid = length*height;
			while (true) {
				if (le-1>=p && ri+1<=q) {
					//양쪽 다 넓힐 수 있는경우 ,더 넓은쪽으로 넓힘
					if (rect[le-1]>=rect[ri+1]) {
						le = le-1;
					} else
						ri = ri+1;
				} else if (le-1>=p) {
					//한쪽만 넓힐 수 있는경우 그쪽으로만 넓힘
					le = le-1;
				} else if (ri+1<=q) {
					ri = ri+1;
				} else
					//넓힐 수 없을 경우 종료
					break;
				//제일 낮은 높이 계산
				height = Integer.min(Integer.min(rect[le], rect[ri]), height);
				//밑변 길이 1 추가
				length++;
				mid = Long.max(mid, height*length);
			}
		}
		return Long.max(Long.max(left, right), mid);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] input = br.readLine().split(" ");
			int n = Integer.valueOf(input[0]);
			if (n==0)
				break;
			rect = new int[n];
			int i;
			for (i=0 ; i<n ; i++)
				rect[i] = Integer.valueOf(input[i+1]);
			System.out.println(maxRect(0, n-1));
		}
	}
}
