"
[문제요약]
지도에 바다와 땅이 표시되어있고, 이는 여러개의 섬을 의미한다.
여기서 2개의 섬을 골라 다리를 연결하고자 할 때, 그 다리가 길이가 최소가 되는 걸 구해라

[해결방법]
일단 섬을 구분해서 번호를 붙여야 한다.
그 뒤에, 각 섬을 확장해 나가며 새로운 배열에 얼마만큼 거리에 있는걸 확장하는지 기록한다.
확장이 끝나면, 그 경계가 서로 다른 두 섬일 경우, 확장 기록된 배열의 같은 위치 2개를 더한게
얼마나 걸린지 알려주는 거다.
BFS는 가중치가 1일 경우 가장 빠른 경로를 찾는 걸 이용함

Time complexity : O(N^2) BFS탐색이 여러번 (배열 전체 탐색이 여러번)
Space complexity : O(N^2)

[추가]
매우 어려운 문제였고 지금까지 배운걸 응용하는 문제였다고 생각.
이문제를 못풀면 기본 그래프챕터 문제 다 풀고 마지막에 풀어볼 것

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
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int[][] map;
    static int[][] extend;
    static int N;

    static void bfs(int i, int j, int n){
        Queue<Coordi> queue = new LinkedList<Coordi>();
        map[i][j] = n;
        visited[i][j] = true;
        queue.add(new Coordi(i,j));
        while(!queue.isEmpty()){
            Coordi now = queue.remove();
            int k;
            for (k=0 ; k<4 ; k++){
                int nextI = now.i + move[k][0];
                int nextJ = now.j + move[k][1];
                if( nextI>=0 && nextI<N && nextJ>=0 && nextJ<N
                 && map[nextI][nextJ]==1 && visited[nextI][nextJ]==false) {
                    visited[nextI][nextJ] = true;
                    map[nextI][nextJ] = n;
                    queue.add(new Coordi(nextI, nextJ));
                }
            }
        }
    }

    static void extending(){
        Queue<Coordi> queue = new LinkedList<Coordi>();
        int i, j, k, q;
        for (i=0 ; i<N ; i++){
            for (j=0 ; j<N ; j++){
                if (map[i][j]!=0){
                    visited[i][j] = true;
                    queue.add(new Coordi(i,j));
                }
            }
        }
        int day = 0;
        while (!queue.isEmpty()){
            day++;
            int size = queue.size();
            for (q=0 ; q<size ; q++){
                Coordi now = queue.remove();
                for (k=0 ; k<4 ; k++){
                    int nextI = now.i + move[k][0];
                    int nextJ = now.j + move[k][1];
                    if( nextI>=0 && nextI<N && nextJ>=0 && nextJ<N
                     && map[nextI][nextJ]==0 && visited[nextI][nextJ]==false) {
                        visited[nextI][nextJ] = true;
                        map[nextI][nextJ] = map[now.i][now.j];
                        extend[nextI][nextJ] = day;
                        queue.add(new Coordi(nextI, nextJ));
                    }
                }
            }
        }

    }


    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        N = scin.nextInt();
        map = new int[N][N];
        extend = new int[N][N];
        visited = new boolean[N][N];
        int i, j;
        for (i=0 ; i<N ; i++){
            for (j=0 ; j<N ; j++){
                map[i][j] = scin.nextInt();
            }
        }
        /* 일단 map에다가 섬끼리 번호를 붙여서 나눠놓는다.
        그리고 각 번호 붙인거를 싹다 큐에 넣고 시작해서 bfs 시작. 각 번호가 붙은
        섬들을 확장시켜놓는다.
        동시에 extend라는 배열에는 몇일째에 확장했는지의 정보를 기록해 놓는다.
        일단 섬끼리 번호 나누기*/
        int count = 1;
        for (i=0 ; i<N ; i++){
            for (j=0 ; j<N ; j++){
                if (map[i][j]!=0 && visited[i][j]==false){
                    bfs(i,j,count);
                    count++;
                }
            }
        }
        //이제 map에 번호붙이기 완료. 확장시키고 그거 기록하는 일 남음
        visited = new boolean[N][N];
        extending();

        //이제 map에서 경계가 다르고, 다리가 최소인거 찾으면 됨,
        //여기서 한번 실패함 오류확인
        int result = Integer.MAX_VALUE;

        for (i=0 ; i<N ; i++){
            for (j=0 ; j<N ; j++){
                if (j+1<N && map[i][j] != map[i][j+1])
                    result = Integer.min(result, extend[i][j] + extend[i][j+1]);
                if (i+1<N && map[i][j] != map[i+1][j])
                    result = Integer.min(result, extend[i][j] + extend[i+1][j]);
            }
        }
        System.out.println(result);
        scin.close();
    }
}
