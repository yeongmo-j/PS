"
[문제요약]
1부터 N까지의 노드를 가진
트리의 인오더, 포스트오더의 순서가 입력으로 들어오고,
이를 통해 프리오더로 출력해라

[해결방법]
인오더 : LVR
포스트오더 : LRV
프리오더 : VLR

우선 포스트오더를 잘 살펴보자. 포스트오더의 맨 마지막 순서는 루트가 오게 된다!
그리고 인오더에서 루트를 알면, 그 기준으로 왼쪽 오른쪽 서브트리를 나눌 수가 있다!
프리오더 또한, 왼쪽 오른쪽 서브루트들이 순서만 다를 뿐, 연속적으로 묶여있다!

이를 잘 이용하면
1. 포스트오더의 맨 마지막 원소가 뭔지 알아낸다 (root)
2. 인오더에서 root가 어딨는지 살펴본다.
3. 그를 기준으로 왼쪽, 오른쪽으로 나눈다.
4. 같은 개수만큼 프리오더의 마지막 하나 뺀 것들중에 인오더와 같은 개수만큼 왼쪽과 오른쪽으로 나눈다
5. 분할한다. 루트 + 왼쪽분할 + 오른쪽분할 을 통해 프리오더로 만들 수가 있다.

이제 시간복잡도를 알아보자.
1~5까지당 루트 하나!만 골라내기 떄문에, 이를 총 N번 해야 한다.
각 루프 당 1, 3, 4는 O(1)이 걸리는데
문제는 2이다. 2를 하기위해 모든 원소를 다 살펴본다면,총 O(N^2)이 되겠지만,

애초에 처음에 어떤 원소가 어딨는지 구해놓으면, O(N+N) = O(N)이 된다.

Time complexity : O(N)
Space complexity : O(N) 스택의 높이

[추가]
진짜 좋은 문제

"
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main{
	static int[] inorder;
	static int[] postorder;
	static int[] where;
	static LinkedList<Integer> list;

	static void run(int ins, int inl, int pos, int pol){
		if (pos>pol){
			return;
		}
		int root = postorder[pol];
		int rootInorderIndex = where[root];
		int len = rootInorderIndex - ins;
		list.add(root);
		run(ins, rootInorderIndex-1, pos, pos+len-1);
		run(rootInorderIndex+1, inl, pos+len, pol-1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		inorder = new int[N];
		postorder = new int[N];
		where = new int[N+1];
		list=  new LinkedList<Integer>();
		String[] temp = br.readLine().split(" ");
		int i;
		for (i=0 ; i<N ; i++)
			inorder[i] = Integer.valueOf(temp[i]);
		temp = br.readLine().split(" ");
		for (i=0 ; i<N ; i++)
			postorder[i] = Integer.valueOf(temp[i]);
		for (i=0 ; i<N ; i++)
			where[inorder[i]] = i;
		run(0,N-1,0,N-1);
		for (int n : list){
			System.out.print(n + " ");
		}
	}
}
