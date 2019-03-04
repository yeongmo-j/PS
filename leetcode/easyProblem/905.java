'''
[문제요약]
int 배열에서 짝수는 앞으로 홀수는 뒤로 보내는 문제

[해결방법]
새로운 배열 하나하나 만들어준 다음에
배열 원소 하나하나 판별해가며 짝수면 앞에서부터, 홀수면 뒤에서부터 채워줬다.


time complexity : theta(N)
space complexity : theta(N)

[추가]
맨처음에 퀵솔트를 하려했으나, 그렇게되면 홀짝이 반복되서 나오므로 실패했다.
그냥 하나하나 살펴봐도 N번이니까 충분할듯 하다

'''

class Solution {

    public int[] sortArrayByParity(int[] A)
    {
        int size = A.length;
        int[] result = new int[size];
        int front = 0, back = size-1;
        for (int temp : A)
        {
            if (temp%2==0)
                result[front++] = temp;
            else
                result[back--] = temp;
        }
        return result;
    }
}
