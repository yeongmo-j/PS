"
[문제요약]
토마토 상자의 토마토가 배열로 들어오는데
1은 익은토마토 0은 안익은토마토 -1은 빈곳을 뜻한다.
익은 토마토는 다음날 상하좌우의 안익은토마토를 익힌다.
몇일지나야 다익니?(최소) & 고립되어서 못익는게 있으면 -1 리턴

[해결방법]
BFS의 특성.
동일한 거리에 있는것들은 같은 시간내에 전파시키고 계속 전파됨(가중치가 1이면)
BFS의 가중치가 모두 1이면, 최단거리를 풀 수 있음!!!

대신 여기선 시작점이 여러개다.(1로 표시된 모든 곳을 큐에 넣고 시작하자) 이부분이 특이함@@@@@@@@@@@

Time complexity : O(N*M)
Space complexity : O(N*M)

[추가]
(기초 그래프 챕터에 있음)
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
    int[][] tomato;
    int[][] visited;
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int M = scin.nextInt();
        int N = scin.nextInt();
        tomato = new int[N][M];
        int i, j;
        for (i=0 ; i<N ; i++){
            String temp = scin.next();
            for (j=0 ; j<M ; j++){
                tomato[i][j] = (int)(temp.charAt(j)-'0');
            }
        }
        Queue<Coordi> queue = new LinkedList<Coordi>();
        for (i=0 ; i<N ; i++){
            for (j=0 ; j<M ; j++){
                if (tomato[i][j]==1){
                    queue.add(new Coordi(i,j));
                }
            }
        }
        int day = -1;
        int k, s;
        while (!queue.isEmpty()){
            day++;
            int size = queue.size();
            for(k=0 ; k<size; k++){
                Coordi now = queue.remove();
                for (s=0 ; s<4 ; s++){
                    int nextI = now.i + move[s][0];
                    int nextJ = now.j + move[s][1];
                    if (nextI>=0 && nextI<N && nextJ>=0 && nextJ<M && tomato[nextI][nextJ]==0){
                        tomato[nextI][nextJ]=1;
                        queue.add(new Coordi(nextI,nextJ));
                    }
                }
            }
        }
        System.out.println(day);
        scin.close();
    }
}
