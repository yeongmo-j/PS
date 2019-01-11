'''
[문제요약]
2차원 배열 주어진 다음에,
행이나 열을 반전시킬 수 있음.
그러한 과정을 여러번 한 다음에,
각 행별로 이진수로 취급하고 10진수로 변환했을 때, 그 합의 최대값을 구해라

[해결방법]
일단 자리수별로 제일 큰 값을 찾을 땐, 제일 앞에 있는 수가 중요함. 그러므로
각 행에서 첫번째 원소가 0인것들은 행별로 반전을 시켜준다.
그다음엔 열별로 비교를 한다(행별로 비교하면 그 앞의자리수가 바뀌므로 안됨)
각 열별로 비교를 할 때, 해당 열에 0이 더 많으면 그 열을 반전시켜준다.
이 과정을 거치게 되면 완성이 되는데, 이걸 이진수로 변환해 준다.
맨 앞자리부터 시작해서 다 더해주고,
다음자리로 넘어갈 땐, 총 합에서 2를 곱해준다음에, 그 열을 더해준다.

Time complexity : O(N*M) N은 행, M은 열
Space complexity : O(1) 그냥 고정된 크기만큼만 필요하다.

[추가]
^=연산자를 통해 반전시켜줄 수 있다.
그리고 각 자리수별로 shift 연산을 통해 이진수로 변환시켜줄 수 있다!
'''

class Solution {
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int count1, count0;
        int i,j;
        int sum=0;
        for (int[] rows : A)
        {
            if (rows[0]==0)
            {
                for (i=0 ; i<col ; i++)
                    rows[i] = rows[i]==0 ? 1 : 0;
            }
        }
        for(j=1 ; j<col ; j++)
        {
            count0=0;
            count1=0;
            for (i=0 ; i<row ; i++)
            {
                if (A[i][j]==1)
                    count1++;
                else
                    count0++;
            }
            if (count0>count1)
            {
                for (i=0 ; i<row ; i++)
                    A[i][j] = A[i][j]==0 ? 1 : 0;
            }
        }
        for(j=0 ; j<col ; j++)
        {
            sum*=2;
            for (i=0 ; i<row ; i++)
                sum+=A[i][j];
        }
        return sum;
    }
}
