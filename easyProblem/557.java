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

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int front=0;
        int start = 0;
        int index = 0;
        int len = s.length();
        while(true)
        {
            index = s.indexOf(" ");
            if (index==-1)
            {
                reverse(arr, start, len-1);
                break;
            }
            reverse(arr, start, start+index-1);
            start+=index+1;
            s = s.substring(index+1);
        }
        String str = new String(arr);
        return str;
    }
}
