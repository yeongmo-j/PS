'''
[문제요약]
문자열 가지고 놀기

[해결방법]

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''
class Solution {
    void reverse(char[] arr, int p, int q)
    {
        int i, end;
        if ((q-p)%2==0)
            end = (q-p)/2;
        else
            end = (q+1-p)/2;
        char temp;
        for (i=0 ; i<end ; i++)
        {
            temp = arr[p+i];
            arr[p+i] = arr[q-i];
            arr[q-i]=temp;
        }
    }
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        reverse(str, 0, s.length()-1);
        return new String(str);

    }
}
