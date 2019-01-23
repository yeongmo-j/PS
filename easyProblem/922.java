'''
[문제요약]
배열 안에 짝수들은 짝수인덱스에, 홀수들은 홀수인덱스에 집어넣기

[해결방법]
짝수인덱스용 변수, 홀수인덱스용 변수 만들어놓고
배열 원소 하나씩 보면서 짝수면 인덱스에 넣고 +2씩 해줬다.

Time complexity : O(N);
Space complexity : O(N);

[추가]
for each로 했으면 더 편했을 꺼 같다.
'''
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] result = new int[len];
        int even=0, odd=1, temp;
        for (int i=0 ; i<len ; i++)
        {
            temp = A[i];
            if (temp%2==0)
            {
                result[even] = temp;
                even+=2;
            }
            else
            {
                result[odd] = temp;
                odd+=2;
            }
        }
        return result;
    }
}
