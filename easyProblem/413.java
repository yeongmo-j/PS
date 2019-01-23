'''
[문제요약]
배열이 주어지고, 배열의 부분배열 중에서
등차수열인게 몇개인지 찾기(원소가 3개 이상이여야 함)

[해결방법]
앞에서부터 하나하나 살펴갔다.일단 앞의3개가 등차수열이면, 뒤로 한칸씩 넘어가며 언제까지 등차수열인지 확인.
끝나면 다음칸으로 넘어가서 반복.

Time complexity : O(N^2);
Space complexity : O(1);

[추가]


'''
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count=0;
        int p, r;
        int gap;
        for (p=0 ; p<A.length-2 ;p++){
            if (A[p+1]-A[p]==A[p+2]-A[p+1]){
                count++;
                gap = A[p+1]-A[p];
                r = 2;
                while (p+r+1<A.length){
                    if (A[p+r+1]-A[p+r]==gap){
                        count++;
                        r++;
                    }
                    else
                        break;
                }
            }
        }
        return count;
    }
}
