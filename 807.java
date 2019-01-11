'''
[문제요약]
2차원 배열로 각 건물의 높이가 들어옴
4면에서 봤을때 제일 높은 건물의 높이가 스카이라인임
스카이라인은 유지하면서, 각 건물의 높이를 높이고 싶다
어떻게 해야 최대로 높힐 수 있을까? 총 높인 건물 높이의 합을 구하라

[해결방법]
일단 배열을 2개 만든다.
하나는 배열의 행의 크기만큼 : 옆에서 본 스카이라인이 저장됨
하나는 배열의 열의 크기만큼 : 앞에서 본 스카이라인이 저장됨.
원소들을 하나하나 살펴보며 스카이라인을 만든다 (최대값 비교)
그다음에 원소들 하나하나 다시 살펴보며 앞에서본거,옆에서본거 스카이라인중에 더 "작은값"보다 작거나 같아야 한다.
그러므로 그 값에서 원래의 높이를 빼 준게 증축한 건물의 높이.
이것들을다 합해주면 된다.

Time complexity : O(N) :N은 2차원 배열 원소의 개수. 총 2번을 탐색한다.
Space complexity : O(r+c) : row와 cloumn의 개수

[추가]
 Math.max
 Math.min
 을 사용하면, if문에서 최대값 비교하거나, 증축할 때,최소값 비교하는걸 줄여준다.
'''
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] skyFront = new int[column];
        int[] skySide = new int[row];
        int i, j;
        int small;
        int sum=0;
        for (i=0 ; i<row ; i++){
            for (j=0 ; j<column ; j++){
                if (skySide[i]<grid[i][j])
                    skySide[i] = grid[i][j];
                if (skyFront[j]<grid[i][j])
                    skyFront[j] = grid[i][j];
            }
        }
        for (i=0 ; i<row ; i++){
            for (j=0 ; j<column ; j++){
                small = skySide[i]<=skyFront[j] ? skySide[i] : skyFront[j];
                sum += (small - grid[i][j]);
            }
        }
        return sum;
    }
}
