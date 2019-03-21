"
[문제요약]
트리의 지름 찾기(어느 한 점에서 다른 한점까지 길이 중 최대 길이 찾기)


[해결방법]
트리는 사이클 없는 무방향 그래프 이므로, 한 점에서 bfs 그래프 탐색을 하면
모든 점에 도달 할 수 있다.
이 때, 루트로 시작해 bfs로 탐색하며 그 점까지 걸리는 길이를 저장해 놓는다.
이중 최고값을 찾는다. 이는 가장 깊숙히 있는 점이 되고, 이를 a라고 하겠다
그렇다면, 이제 다시 a로 시작하는 bfs를 돌려주고, 그 걸리는 길이를 또 저장해 놓는다
그렇게 되면, 이는 가장 깊숙히 있는 점과 가장 멀리 떨어진 점을 구할 수 있고,
이 두 점사이의 거리가 트리의 지름이 된다.


Time complexity : O(N) (전체 문자열의 문자개수)
Space complexity : O(N)

[추가]
@@@@@@@

"
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
아예 나와야 하는 걸 집어넣어 버리면 됨!!
"


import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    static LinkedList<int[]>[] edge;
    static boolean[] visited;
    static int[] far;

    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
        	int now = queue.remove();
            for (int[] next : edge[now]){
                if(visited[next[0]]==false){
                    visited[next[0]] = true;
                    queue.add(next[0]);
                    far[next[0]] = far[now] + next[1];
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int n =scin.nextInt();
        edge =(LinkedList<int[]>[]) new LinkedList[n+1];
        visited = new boolean[n+1];
        far = new int[n+1];
        int i;
        for (i=1 ; i<=n ; i++)
            edge[i] = new LinkedList<int[]>();
        for (i=1 ; i<n ; i++){
            int a = scin.nextInt();
            int b = scin.nextInt();
            int c = scin.nextInt();
            int[] arr = {b,c};
            edge[a].add(arr);
            int[] arr2 = {a,c};
            edge[b].add(arr2);
        }
        //edge[i]에는 i와연결된 정점이 {정점번호,가중치}의 형태로 저장되어 있다.
        bfs(1);
        int max = 0;
        int maxV = 1;
        for (i=2 ; i<=n ; i++){
            if (far[i]>max){
                max = far[i];
                maxV = i;
            }
        }
        visited = new boolean[n+1];
        far = new int[n+1];
        bfs(maxV);
        for (i=1 ; i<=n ; i++){
            max = Integer.max(max,far[i]);
        }
        System.out.println(max);
        scin.close();
    }
}
