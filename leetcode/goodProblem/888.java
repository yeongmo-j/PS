'''
[문제요약]
배열 두개가 주어지고,
배열 두개의 합이 서로 같아지도록
둘의 원소 하나씩을 교환해야한다.

[해결방법]
둘의 합을 각각 구해서 차를 구한다.
또 그 반을 나눠서
앞의꺼에서 뒤에꺼를 뺸게 차의 반이면 된다.

Time complexity : O(N*M) 각각 배열의 크기.
Space complexity : O(1);

[추가]
B를 다 HashSet에 넣어주고,
A에다가 위에서 구한 차의 반을 더한게 해쉬셋에 있어야 한다.
그러므로 시간은 O(max(N,M))이 된다.

'''

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int asum=0, bsum=0;
        int i,j;
        int[] result = new int[2];
        for (i=0 ; i<A.length ; i++)
            asum+=A[i];
        for (i=0 ; i<B.length ; i++)
            bsum+=B[i];
        int diff = (asum-bsum)/2;
        for (i=0 ; i<A.length ; i++){
            for (j=0 ; j<B.length; j++){
                if (A[i]-diff==B[j]){
                    result[0]=A[i];
                    result[1]=B[j];
                    return result;
                }
            }
        }
        return result;
    }
}
