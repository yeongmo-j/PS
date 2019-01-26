"
[문제요약]
2차원 배열이 주어지고, 각 값을 가지고 있다.
한 좌표를 정해주고, 새로운 값을 정해준다.
그러면 그 좌표에 상하좌우에 같은 값이 있으면 다 새로운 값으로 바꿔주고, 반복
그림판 페인트처럼.

[해결방법]
같은크기의 배열 하나 만들어주고, 방문표시를 사용했다.
그다음 4방향 재귀.
!!!2차원 배열이 또 필요한게 불만.!!!

Time complexity : O(N); 배열의 크기
Space complexity : O(N) 배열의 크기 + 스택의 크기

[추가]
@@@@@@좋은방법@@@@@@@
새로운 배열 선언 안하고도 할 수 있다.
일단 지금 색깔이 뭔지 저장한뒤에 ,인자로 하나를 더넘긴다.
그래서, 이 색과 같은거만 방문해서 새로운색으로 바꾼다.
이렇게되면 같은색이 아닌것들만 골라서 방문이 가능하다.

그런데 만약 맨처음에 색깔이 똑같은색이면?? (첫 픽셀과 새로운 색이 같다면?)
ㄴ 내생각은 일단 더미색깔 하나 만들어서 그색으로 덮은다음에
진짜 새로운  색으로 한번 더덮으면 되려나?? -> 시간 2배 걸린다.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}

"
class Solution {

    int[][] isVisited;

    void run(int[][] image, int sr, int sc, int newColor){
        isVisited[sr][sc]=1;
        if (sr-1>=0 && isVisited[sr-1][sc]==0)
            if (image[sr][sc]==image[sr-1][sc])
                run(image, sr-1, sc, newColor);
        if (sc+1<image[0].length && isVisited[sr][sc+1]==0)
            if (image[sr][sc+1]==image[sr][sc])
                run(image, sr, sc+1, newColor);
        if (sr+1<image.length && isVisited[sr+1][sc]==0)
            if (image[sr+1][sc]==image[sr][sc])
                run(image, sr+1, sc, newColor);
        if (sc-1>=0 && isVisited[sr][sc-1]==0)
            if (image[sr][sc-1]==image[sr][sc])
                run(image, sr, sc-1, newColor);
        image[sr][sc]=newColor;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        isVisited = new int[image.length][image[0].length];
        run(image, sr, sc, newColor);
        return image;
    }
}
