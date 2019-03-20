"
[문제요약]
n*n형태의 지도가 하나 들어온다.
0은 집이 없는거고 1은 집이 있는건데,
위 아래 왼 오른쪽 붙어있는거끼리는 다 단지에 속해있다.
단지(덩어리)들이 몇개있는지를 리턴하고,
각 단지에 속한 아파트도 몇개씩인지도 오름차순으로 리턴해라.

[해결방법]
각 배열 원소 탐색하면서 1이면, 거기부터 메소드를 실행시킨다.
메소드는 원소의 인덱스를 인자로 받으며,
들어가면 1을 센 다음에, 자기의 지도를 0으로 바꾼다.
그 뒤 4방향을 재귀로 구해서 1에 더해준 다음에, 그 값을 리턴한다.

이게 완료되면, 자기가 속한 단지는 다 0으로 바뀌고, 총 몇개인지가 리턴된다.
그래서 그걸 리스트에 저장하고, 정렬해서 출력해주면 된다.

Time complexity : O(N^2)
Space complexity : O(N^2)

[추가]
"


import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class Main{
    static int[][] map;
    static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
    static int n;
    static int score(int i, int j){
        int result = 1;
        map[i][j] = 0;
        for (int k=0 ; k<4 ; k++){
            int nextX = i+direction[k][0];
            int nextY = j+direction[k][1];
            if (nextX>=0 && nextX<n && nextY>=0 && nextY<n && map[nextX][nextY]==1){
                result += score(nextX, nextY);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        LinkedList<Integer> resultList = new LinkedList<Integer>();
        int N =scin.nextInt();
        n = N;
        map = new int[N][N];
        int i, j;
        for (i=0 ; i<N ; i++){
            String temp = scin.next();
            for (j=0 ; j<temp.length(); j++){
                map[i][j] = (int)(temp.charAt(j)-'0');
            }
        }
        for (i=0 ; i<N ; i++){
            for (j=0 ; j<N ; j++){
                if (map[i][j] == 1){
                    int score = score(i,j);
                    resultList.add(score);
                }
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (int result : resultList){
            System.out.println(result);
        }
        scin.close();
    }

}
