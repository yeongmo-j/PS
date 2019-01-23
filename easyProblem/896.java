'''
[문제요약]
배열이 계속 증가하는지, 계속 감소하는지 확인.

[해결방법]
Time complexity : O(N) 배열의 크기.
Space complexity : O(1);

[추가]
둘다 내려오면서 하지말고
각각 메소드로 만들어준뒤에
메인에선 || 으로 둘중 하나만 되게 완성하기.

'''
class Solution {
    public boolean isMonotonic(int[] A) {
        int length = A.length;
        int i;
        boolean monotonic = true;
        for (i=0 ; i<length-1 ; i++){
            if (A[i]>A[i+1]){
                monotonic = false;
                break;
            }
        }
        if (monotonic)
            return true;
        monotonic = true;
        for (i=0 ; i<length-1 ; i++){
            if (A[i]<A[i+1]){
                monotonic = false;
                break;
            }
        }
        if (monotonic)
            return true;
        return false;
    }
}
