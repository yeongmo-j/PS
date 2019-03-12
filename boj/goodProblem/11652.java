"
[문제요약]
카드의 범위는 -2^62부터 2^62까지인데
카드가 N개 들어올 때, 그중 가장 많이 들어온 카드는 무엇인가?


[해결방법]
범위가 정해져있다고 radix sort를 할 필요가 없다는걸 보여주는 예.
그냥 N짜리 배열에 입력 받아서
NlgN으로 정렬 하고
그 N개중에 가장 많ㅇ이나온값 찾는거 : N번 으로 끝낼 수 있다
그러므로 시간복잡도 : NlgN + N = NlgN

Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
N개중에 많이나온 값 찾는거 while루프 내 생각엔 괜찮은거 같음
i=0;
while (i<N) {
  int count = 0;
  int j = i;
  while (j<N && arr[j]==arr[i]) {
    count++;
    j++;
  }
  if (count > maxCount) {
    maxCount = count;
    maxNum = arr[i];
  }
  i=j;
}
이부분
"

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();

		long[] arr = new long[N];
		int i;
		for (i=0 ; i<N ; i++) {
			arr[i] = scin.nextLong();
		}

		Arrays.sort(arr);

		long maxNum = 0L;
		int maxCount = 0;

		i=0;
		while (i<N) {
			int count = 0;
			int j = i;
			while (j<N && arr[j]==arr[i]) {
				count++;
				j++;
			}
			if (count > maxCount) {
				maxCount = count;
				maxNum = arr[i];
			}
			i=j;
		}

		System.out.println(maxNum);

		scin.close();
	}
}
