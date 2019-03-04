"
[문제요약]
L,W을 구하여라
area가 입력으로 들어오고,
L*W=area
L >= W
두개의 차가 최소로 되게.


[해결방법]
일단 sqrt를 구한다음에, 나누어 떨어질때까지 sqrt를 1씩 줄인다
그다음 area/sqrt, sqrt 리턴.

Time complexity : O(N^(1/2)) N은 area의 크기.
Space complexity : O(1)

[추가]

"


class Solution {
    public int[] constructRectangle(int area) {
        int sqrt = (int)Math.sqrt(area);
        while (area%sqrt!=0)
            sqrt--;
        return new int[]{area/sqrt, sqrt};
    }
}
