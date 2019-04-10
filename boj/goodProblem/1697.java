"
[문제요약]
n과 k가 주어지고
n은 n-1 / n+1 / 2*n 중에 하나를 1초후에 갈 수 있다
몇초있다 k에 갈 수 있음?(최소 )

[해결방법]
DP이용
arr[i]는 i까지 이동하는데 걸리는 최소 시간
arr[i]가 갱신 될 때마다 큐에 넣어줘서 시뮬레이션 한다

Time complexity : O(1) (1000000) 1씩이동해도 이정도
Space complexity : O(1)

[추가]
갱신 될 떄마다 큐에 넣어주는 게 아니라
그냥 처음 도착할때만 해줘도 된다. 왜냐면 BFS 각 단계가 진행될수록 큐 뒤에 쌓이게 되는데
큐에서 먼저 나왔다는건 먼저 들어갔다 : 먼저 도착했다는 말이 되기 때문에
그러므로, 방문 정보를 알려주는 배열과, 몇번째로 방문했는지 알려주는 배열 두개를 가지고
하면 시간이 더 짧아진다

그리고 if문 복붙 3개 안좋으니까
배열 만들어서 for문으로 돌리도록 하자!!

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.valueOf(input[0]);
		int k = Integer.valueOf(input[1]);
		if (n==k)
			System.out.println(0);
		else {
			int[] arr = new int[100001];
			Queue<Integer> queue=  new LinkedList<Integer>();
			queue.add(n);
			while(!queue.isEmpty()) {
				int now = queue.remove();
				int front = now-1;
				int back = now+1;
				int teleport = now*2;
				if (front>=0) {
					if (arr[front]==0 || arr[front]>arr[now]+1) {
						arr[front] = arr[now]+1;
						queue.add(front);
					}
				}
				if (back<=100000) {
					if (arr[back]==0 || arr[back]>arr[now]+1) {
						arr[back] = arr[now]+1;
						queue.add(back);
					}
				}
				if (teleport<=100000) {
					if (arr[teleport]==0 || arr[teleport]>arr[now]+1) {
						arr[teleport] = arr[now]+1;
						queue.add(teleport);
					}
				}
			}
			System.out.println(arr[k]);
		}
	}
}
