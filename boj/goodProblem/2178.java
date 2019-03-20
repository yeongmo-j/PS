"
[문제요약]
미로가 들어오고
1은 연결된 곳(갈수 있는곳)을 뜻한다.
0,0에서 N-1,M-1까지 도착하는 가장 빠른 시간을 구하여라

[해결방법]
DFS는 지맘대로 전진하므로, 가장 빠르다고 보장하지 못한다.
하지만 BFS의 특성을 살펴보자.
지금 연결된거 한번씩 다 돈다음에, 그 연결된거에서 다음연결된거 한번씩 다 돈다.
즉 한번씩 전진할때마다, 거리가 1씩 증가해서 퍼져나가는것이다.
    3
1 2 3
  2 3
이런식으로 (지금 큐에 저장되있는거)탐색할 때마다 거리가 하나씩 늘어난다!!!!!!!
결론 : BFS : 모든 가중치가 1이면, 최단거리 를 계산할 수 있다.
그래서 BFS로 풀었음. 어차피 지금 도착한게 최단거리이므로, 두번다시 방문 안해도 된다->시간복잡도

Time complexity : O(N*M)
Space complexity : O(N*M)

[추가]
(기초 그래프 챕터에 있음)
BFS : 모든 가중치가 1이면, 최단거리 를 계산할 수 있다.
이게 진짜 중요함@@@@@@@@@@@@@@@@@@@@@@
너무중요해@@@@@@@@@@@@@@@@
그리고, score라는 배열을 쓰지 말고, 그냥 자기 도착 했을때, 1을 점수로 바꿔버려도 될꺼 같음.
"

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Coordi{
    int i;
    int j;
    Coordi(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class Main{
    static int N;
    static int M;
    static int[][] map;
    static int[][] score;
    static boolean[][] visited;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    static void bfs(int i, int j, int scores){
        Queue<Coordi> queue = new LinkedList<Coordi>();
        queue.add(new Coordi(i, j));
        int k,s;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (k=0 ; k<size ; k++){
                Coordi now = queue.remove();
                score[now.i][now.j] = scores;
                for (s=0 ; s<4 ; s++){
                    int nextI = now.i + move[s][0];
                    int nextJ = now.j + move[s][1];
                    if (nextI>=0 && nextI<N && nextJ>=0 && nextJ<M && map[nextI][nextJ]==1 && visited[nextI][nextJ]==false){
                        if (score[nextI][nextJ]==0){
                        	visited[nextI][nextJ] = true;
                            queue.add(new Coordi(nextI,nextJ));
                        }
                    }
                }
            }
            scores++;
        }
    }

    public static void main(String[] args){
        Scanner scin= new Scanner(System.in);
        N = scin.nextInt();
        M = scin.nextInt();
        map = new int[N][M];
        score = new int[N][M];
        visited = new boolean[N][M];
        int i, j;
        for (i=0 ; i<N ; i++){
            String temp = scin.next();
            for (j=0 ; j<M ; j++){
                map[i][j] = (int)(temp.charAt(j)-'0');
            }
        }
        bfs(0,0,1);
        System.out.println(score[N-1][M-1]);
        scin.close();
    }
}
