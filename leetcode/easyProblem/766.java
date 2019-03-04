'''
[문제요약]
2차원 매트릭스 주어지고 왼쪽위에서 오른쪽아래 대각선 일직선에 있는 원소들끼리 다 같은지 확인

[해결방법]
일단 0행에 있는것들 대각선으로 쫙 확인
그다음 0열에 있는거 대각선으로 쫙 확인
하면 정확히 한번씩만 탐색한다.

Time complexity : O(N*M) N은 행크기 M은 열크기
Space complexity : O(1)

[추가]
대각선상에서 x좌표-y좌표를 한거끼리는 동일하고,
이 값은 유일하다(대각선마다 다 다르다)
그러므로 이 값을 키로 하는 해쉬맵을 사용.
만약 그 값이 들어있으면, matrix[i][j]를 넣음.
아니면 꺼내서 확인 틀리면 끝.

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return False;
            }
        }
        return True;
    }
}
'''
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i,j,num;
        boolean isToep = true;
        for (i=0 ; i<m; i++)
        {
            num = matrix[i][0];
            for (j=0 ; i+j<m&&j<n ; j++)
            {
                if (matrix[i+j][j]!=num)
                {
                    isToep = false;
                    break;
                }
            }
            if (!isToep)
                break;
        }
        if (isToep)
        {
            for (j=1 ; j<n ; j++)
            {
                num = matrix[0][j];
                for (i=0 ; i<m&& j+i<n ; i++)
                {
                    if (matrix[i][j+i]!=num)
                    {
                        isToep=false;
                        break;
                    }
                }
            }
        }
        if (isToep)
            return true;
        return false;
    }
}
