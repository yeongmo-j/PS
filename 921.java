'''
[문제요약]
(과 )들로 이루어진 문자열이 들어온다.
() 쌍이여야만 완성됨.
여기에다 (랑 )를 총 몇개 더해야 결함 없는 괄호들이 완성되니?

[해결방법]
직관적인 문제.
(와 )의 개수를 앞에서부터 세주는데 (가 1개 이상일때 )가 들어오면 (를 삭제해준다.

Time complexity : O(N) N은 문자열의 길이
Space complexity : O(1) : 원소의 수 만큼.

[추가]
'''

class Solution {
    public int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        for(char c : S.toCharArray()){
            if (c=='(')
                left ++;
            else
            {
                if (left<=0)
                    right ++;
                else
                    left --;
            }
        }
        return left+right;
    }
}
