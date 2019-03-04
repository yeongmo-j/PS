'''
[문제요약]
2차원 배열에서 하나 기준으로 소용돌이 모양으로 탐색하기.
벽 넘어서도 탐색은 하는데 경로는 저장 안함.
배열 안의 경로들 출력하기

[해결방법]
4방향이 있는데, 소용돌이의 크기는 점점 커지므로 방향 두번 틀때마다 1씩 크기 커지게 해서 탐색했다.

Time complexity : O(N^2) N은 행,열 크기 중 더 큰 크기
Space complexity : O(N*M) N은 행크기 M은 열크기

[추가]
이동할 때 케이스로 나눠서 switch 하지 말고,
step%4로 해서 0~3까지의 인덱스로 나눈 뒤,
int[] xmove = {0,1,0,-1};
int[] ymove = {1,0,-1,0};
int[] sqrmove = {0,1,0,1};
이런식으로 방향이동 해주고, 소용돌이 크기도 키우기!
'''
class Solution {
    int arrayCount;
    int arrayMax;
    int[][] array;

    void addToArray(int x, int y,int R, int C)
    {
        if (x<R && x>=0 && y<C && y>=0)
        {
            array[arrayCount][0]=x;
            array[arrayCount++][1]=y;
        }
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0)
    {
        array = new int[R*C][2];
        arrayCount=0;
        arrayMax=R*C;
        int[] xmove = {0,1,0,-1};
        int[] ymove = {1,0,-1,0};
        int[] sqrmove = {0,1,0,1};
        //0은 오른쪽 1은 아래 2는 왼쪽 3은 위쪽

        int x=r0, y=c0;
        int sqrSize=1;
        int step=0;
        int i;

        while (arrayCount<arrayMax)
        {
            for (i=0 ; i<sqrSize ; i++)
            {
                addToArray(x,y,R,C);
                x+=xmove[step%4];
                y+=ymove[step%4];
            }
            sqrSize+=sqrmove[step%4];
            step++;
        }
        return array;
    }
}
