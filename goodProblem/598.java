"
[문제요약]
m하고 n이 주어지고 ,m*n배열이 0으로 초기화된다.
그리고 [][2]배열이 주어지는데, 배열의 각 행은 [a][b]로 이루어져 있고,
0~a,0~b의 인덱스를 가지는 모든 배열을 1씩 추가한다.

이때, m*n배열의 최대값의 원소의 개수를 구하여라.

[해결방법]
문제를 해석하면,
새로 들어오는 배열에서 각각의 최대로 겹치는 부분 : 제일 작은 x값, y값이 되고,
이 둘을 곱해주면 된다.

Time complexity : O(N) n은 [][2]배열의 크기.
Space complexity : O(1)

[추가]
초기 조건 확인.
만약 배열에 아무것도 안들어올 경우,
m*n 그 자체가 된다.
그러므로 최대값을 m과 n으로 초기화 해야 한다.
더 깔끔한 식 쓰는법 Math.min

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}

"
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx = m;
        int miny = n;
        for (int[] a : ops){
            if (a[0]<minx)
                minx = a[0];
            if (a[1]<miny)
                miny = a[1];
        }
        return minx*miny;
    }
}
