"
[문제요약]
N과 M이 입력으로 들어온다.
1번부터 N번까지의 사람이 원형으로 둘러앉아있고, 1번부터 시작해 M번쨰 사람을 뺸다.
그다음 남은사람들중에 또 M번쨰 사람을 뺀다
이렇게 해서 모든사람을 뺄때까지 반복한 뒤,
 그 순서를 출력하라.

[해결방법]
큐를 이용한다.
일단 시간복잡도 먼저 분석.
한명씩 뺄때마다 M번씩 이동해야 하고,
이게 N번 있어야 사람이 다 빠지므로 O(NM)

큐를 이용해서 문제를 풀 때, M-1번 맨앞에있는걸 맨뒤로 옮긴 뒤에, 맨앞에 있는걸 빼서 출력 해준다.
이를 N-1번 해준 뒤에,
마지막 남은거를 출력해주면 된다.

즉 for 루프를 N-1 * M-1로 중첩해주면 된다.

Time complexity : O(NM)
Space complexity : O(1);

[추가]
맨첨에 풀 때, for루프 안쓰고 큐가 빌때까지 while 루프 썼는데,
for루프의 방법이 훨씬 직관적이고 깔끔한 것 같다.
또, list에 추가했다가 마지막에 출력하는거 보다,
매번 stringbuffer에 일일히 추가해주는게 더욱 간편하고 빠르다.
"

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();

		int N = scin.nextInt();
		int M = scin.nextInt();

		StringBuffer sb = new StringBuffer();
		sb.append('<');

		for (int i=1 ; i<=N ; i++)
			queue.add(i);
		for (int i=0 ; i<N-1 ; i++){
			for (int j=0 ; j<M-1 ; j++)
				queue.add(queue.poll());
			sb.append(queue.poll());
			sb.append(", ");
		}
		sb.append(queue.poll());
		sb.append('>');
		System.out.println(sb);
		scin.close();
	}
}
