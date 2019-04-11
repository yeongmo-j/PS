"
[문제요약]
물통 부피가 각각 a, b, c인 3개가 있다
맨처음에 c에만 가득 찬 상태로 시작 할 때
각각 물통을 계속 채우고 비우고 하면서 물을 이동시킬 때,
a가 비어있을 때, c에 있을 수 있는 모든 물의 부피의 경우를 출력하라

[해결방법]
실제로 시뮬레이션 해본다음에,
a는 0이고 c에 물이 있을 경우에 그 값을 저장해주면 된다.

시뮬레이션을 하기 전, 각각 있을 수 있는 경우의 수를 살펴보자.
a->b
a->c
b->a
b->c
c->a
c->b의 6가지 경우의 수가 있는데,

이를 연결 정보로 해서 BFS를 돌려주면 된다.
visited는 각각 물통의 용량을 정보로 담아야 하기 때문에 ,visited[][][] 3차원 배열로 선언을 해주고,
각 크기는 a+1, b+1, c+1이 된다.(0~a까지 되야 하므로)

그리고, c에 나올 수 있는 경우의 수를 저장 할 때는 ,TreeSet을 통해, 중복 없이 오름차순으로
저장해서 출력하기 쉽게 해준다.


Time complexity : O(A*B*C)
Space complexity : O(A*B*C)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Bucket{
	int a;
	int b;
	int c;
	Bucket(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}


public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int aFull = Integer.valueOf(input[0]);
		int bFull = Integer.valueOf(input[1]);
		int cFull = Integer.valueOf(input[2]);
		boolean[][][] visited = new boolean[aFull+1][bFull+1][cFull+1];
		Queue<Bucket> queue = new LinkedList<Bucket>();
		Set<Integer> result = new TreeSet<Integer>();
		queue.add(new Bucket(0, 0, cFull));
		visited[0][0][cFull] = true;
		while (!queue.isEmpty()) {
			Bucket now = queue.remove();
			if (now.a == 0)
				result.add(now.c);
			//a를 b에 부음
			if (now.a!=0 && now.b<bFull) {
				int fill = Integer.min(now.a, bFull-now.b);
				Bucket next = new Bucket(now.a-fill, now.b+fill, now.c);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
			//a를 c에 부음
			if (now.a!=0 && now.c<cFull) {
				int fill = Integer.min(now.a, cFull-now.c);
				Bucket next = new Bucket(now.a-fill, now.b, now.c+fill);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
			//b를 a에 부음
			if (now.b!=0 && now.a<aFull) {
				int fill = Integer.min(now.b, aFull-now.a);
				Bucket next = new Bucket(now.a+fill, now.b-fill, now.c);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
			//b를 c에 부음
			if (now.b!=0 && now.c<cFull) {
				int fill = Integer.min(now.b, cFull-now.c);
				Bucket next = new Bucket(now.a, now.b-fill, now.c+fill);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
			//c를 a에 부음
			if (now.c!=0 && now.a<aFull) {
				int fill = Integer.min(now.c, aFull-now.a);
				Bucket next = new Bucket(now.a+fill, now.b, now.c-fill);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
			//c를 b에 부음
			if (now.c!=0 && now.b<bFull) {
				int fill = Integer.min(now.c, bFull-now.b);
				Bucket next = new Bucket(now.a, now.b+fill, now.c-fill);
				if (!visited[next.a][next.b][next.c]) {
					visited[next.a][next.b][next.c] = true;
					queue.add(next);
				}
			}
		}
		Iterator<Integer> it = result.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}


	}
}
