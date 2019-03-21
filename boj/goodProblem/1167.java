"
[문제요약]
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
일단 정점의 개수와
각 정점에서 연결된 정점과 그 정점과의 거리가 주어진다
이중에서 두 사이가 제이 긴 거리를 구하여라

[해결방법]
@@@@@@@
일단 트리는 사이클이 없는 연결 그래프 이므로, 어느 정점에서 탐색을 시작하더라도
완전탐색이 가능하다.
그래서 한 정점을 잡고 그 정점에서 떨어진 거리들을 기록한다.
distance[next[0]] = distance[v] + next[1];
거리[다음] = 거리[지금] + 가중치
이런식으로.
그다음에 그 거리가 가장 긴걸 찾는다 = 가장 멀리 떨어진걸 찾는다.

그럼, 그 가장 멀리 떨어진거에서 다시한번 탐색을 한다.
그다음에 또 가장 멀리 떨어진 거리를 찾는다.
그렇게 되면 지름을 구할 수가 있다.

Time complexity : O(N)
Space complexity : O(N)

[추가]
@@@@
매우 좋은 문제라고 생각함
@@@

"


import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<int[]>[] edge;
    static boolean[] visited;
    static int distance[];

    static void diameter(int v){
    	if (edge[v].size()==0)
    		return;
    	for (int[] next : edge[v]) {
    		if (visited[next[0]]==false) {
    			visited[next[0]] = true;
    			distance[next[0]] = distance[v] + next[1];
    			diameter(next[0]);
    		}
    	}
    }

    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int V = scin.nextInt();
        edge = (LinkedList<int[]>[])new LinkedList[V+1];
        visited = new boolean[V+1];
        distance = new int[V+1];
        int i;
        for (i=1 ; i<=V ; i++)
            edge[i] = new LinkedList<int[]>();

        for (i=1 ; i<=V ; i++){
            int a = scin.nextInt();
            while (true){
                int b = scin.nextInt();
                if (b==-1)
                    break;
                int c = scin.nextInt();
                int[] tempArr = {b,c};
                edge[a].add(tempArr);
            }
        }
        //edge[i]의 리스트에는 {x,y}형태의 배열이 리스트의 원소로 이루어져 있는데 이는
        // x와 연결되어있는 간선의 가중치가 y라는 뜻이다.
        visited[1] = true;
        diameter(1);
        int far = 1;
        for (i=2 ; i<=V ; i++) {
        	if (distance[i] > distance[far])
        		far = i;
        }
        distance = new int[V+1];
        visited = new boolean[V+1];
        visited[far] = true;
        diameter(far);
        int max = 0;
        for (i=1 ; i<=V ; i++)
        	max = Integer.max(max, distance[i]);
        System.out.println(max);

        scin.close();
    }
}
