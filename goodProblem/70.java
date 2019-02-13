'''
[문제요약]
계단을 한칸 혹은 두칸씩 올라갈 수 있는데, 총 계단의 수가 주어지고,
올라가는 방법의 수를 구하라.

[해결방법]
DP로 구했다.

Time Complexity = O(N);
Space Complecity = O(N);

[추가]
왜 space가 mb단위로 먹는지?
'''


class Solution {
    int[] cache;
    int last;

    int climb(int n){
        if (n>=last)
            return 1;
        int result = cache[n];
        if (result==0){
            result = climb(n+1)+climb(n+2);
            cache[n]=result;
        }
        return result;
    }

    public int climbStairs(int n) {
        cache = new int[n+1];
        last = n;
        return climb(1);
    }
}
