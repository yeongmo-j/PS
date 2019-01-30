"
[문제요약]
직사각형 2개의 좌표가 들어오고,
2개가 겹치는지 안겹치는지?

[해결방법]

Time complexity : O(1);
Space complexity : O(1)

[추가]
"

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec2[2]<=rec1[0] || rec2[0]>=rec1[2] || rec2[3]<=rec1[1] || rec2[1]>=rec1[3]);
    }
}
