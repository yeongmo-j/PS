"
[문제요약]
N개의 노드,
1번이 루트
N-1개의 연결된 두 정점이 들어올 때,
2번 노드부터 끝까지 각자 자기의 부모 번호를 출력해라

[해결방법]
@@@@@@@
일단 트리는 사이클 없는 그래프이고, 다 연결 되어 있다.
그러므로, 1번부터 BFS를 실행 해 주면,
다음껄로 넘어갈 때, 그 과정을 기록해 주면, 다음껄로 넘어가기 전에 있는 노드가
자신의 부모노드가 된다.

즉, 그래프랑 똑같이 리스트로 edge를 저장 해 둔 뒤에,
1번부터 BFS를 해줘라.
그다음 노드를 큐에 넣기 전에, parent[다음노드] = 지금노드
를 기록해 두면 된다.

Time complexity : O(N) BFS
Space complexity : O(N)

[추가]
@@@@
매우 좋은 문제라고 생각함
@@@

"

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        LinkedList<Integer>[] edge = (LinkedList<Integer>[]) new LinkedList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        int i;
        for (i=0 ; i<N-1 ; i++){
            int a = scin.nextInt();
            int b = scin.nextInt();
            edge[a].add(b);
            edge[b].add(a);
        }
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int now = queue.remove();
            for (int next : edge[now]){
                if (visited[next]==false){
                    visited[next] = true;
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
        for (i=2 ; i<=N ; i++){
            System.out.println(parent[i]);
        }
        scin.close();
    }
}
