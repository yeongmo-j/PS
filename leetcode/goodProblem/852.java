'''
[문제요약]
배열이 주어지고, 그 배열은 산 형태로 되어있는데(점점 높아지다 점점 낮아짐)
그 꼭대기를 찾아라.

[해결방법]
탐색해서 제일 큰걸 찾았음.

Time complexity : O(N)
Space complexity : O(1);

[추가]
만약 다시 낮아지기 시작한다면? 그 뒤를 탐색할 필요는 없음
int i = 0;
while (A[i] < A[i+1]) i++;
return i;
이렇게 간편하게 가능하다!!!

아니면 binary search를 통해 lgN으로 줄일 수 있다!!
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
'''

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        int len = A.length;
        for (int i=0 ; i<len ;i++)
            if (A[i]>A[max])
                max=i;
        return max;
    }
}
