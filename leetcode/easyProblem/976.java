'''
[문제요약]
정수로 이루어진 배열이 주어지고, 그중에서 3개를 골라 만들수 있는 삼각형의 둘레의 최대 길이를 구하여라.

[해결방법]
삼각형의 성립조건
제일긴거<나머지두개합
을 이용해야한다.
일단 정렬 한 뒤에
맨 뒤부터, 그 앞에 두개의 합보다 작은지 확인.

Time complexity : O(N);
Space complexity : O(nlgN) : 스택

[추가]
Arrays.sort(A)
로 정렬 가능하다.
'''
class Solution {
    void quickSort(int[]A, int p, int q)
    {
        if (p<q){
            int r = partition(A,p,q);
            quickSort(A,p,r-1);
            quickSort(A,r+1,q);
        }
    }
    int partition(int[] A, int p, int q)
    {
        int k =A[p];
        int i=p;
        int j;
        int temp;
        for (j=i+1 ; j<=q ; j++){
            if (A[j]<=k){
                i++;
                temp = A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        temp=A[p];
        A[p]=A[i];
        A[i]=temp;
        return i;
    }
    public int largestPerimeter(int[] A) {
        quickSort(A,0,A.length-1);
        for (int i=A.length-1; i>=2 ; i--){
            if(A[i-2]+A[i-1]>A[i])
                return A[i-2]+A[i-1]+A[i];
        }
        return 0;
    }
}
