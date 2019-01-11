'''
[문제요약]
2차원 배열 주어지고
좌우 뒤집은다음에 1과 0 반전

[해결방법]
새로운 2차원 배열 만들어준다음에
하나하나 채워나갔다.
원래의 배열이 1이면 0으로, 0이면 1로, 행의 순서는 그대로, 열은 뒤에서부터 반대로 채워나갔다.

Time complexity : O(N);
Space complexity : O(N);

[추가]
행과 열 주의.
좌우로 뒤집는건 행의 순서는 유지되고, 열의 순서만 바뀐다.
그러므로 채워줄 때
A[i][열크기-1-j] 이렇게 채워줘야 한다.

배열 탐색 할 때,
for 루프가 인덱스의 반만큼만 오게 해준 다음에
A[i]와 A[size-1-i]를 함께 판별하면 루프를 반만 돌아도 된다.
근데 이게 그렇게까지 효과가 있을런지는 잘 모르겠음.

배열 이용할 때 for each 루프를 잘 사용하면 좋을것 같다.
'''

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int sizeOfRow = A.length;
        int sizeOfColumn = A[0].length;
        int[][] result = new int [sizeOfRow][sizeOfColumn];
        int temp;
        for (int i=0 ; i<sizeOfRow ; i++)
        {
            for (int j=0 ; j<sizeOfColumn ; j++)
            {
                temp = A[i][j] == 1 ? 0 : 1;
                result[i][sizeOfColumn-1-j] = temp;
            }
        }
        return result;
    }
}
