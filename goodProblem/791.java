'''
[문제요약]
문자열에서 패턴 주어지고
해당 문자열에서 패턴에 있는 알파벳이라면, 서로 그 순서를 유지해야한다.
패턴에 없는 알파벳은 뒤에 붙임

[해결방법]
그냥 패턴 앞에서부터 캐릭터로 하나씩 돌아가며
그게 문자열에 존재하면, 다 루프로 삭제해주고 삭제해준만큼 원래꺼에 붙여줬다.

Time complexity : O(N*M) N은 패턴크기 ,M은 판별한 문자열 크기
Space complexity : O(1)


[추가]
N^2은 너무 부담스럽다.
'''
class Solution {
    public String customSortString(String S, String T)
    {
        char[] s = S.toCharArray();
        String result="";
        String temp="";
        int index;
        for (char c : s)
        {
            temp = String.valueOf(c);
            if(T.contains(temp))
            {
                while (T.contains(temp))
                {
                    index = T.indexOf(temp);
                    T = T.substring(0,index)+T.substring(index+1);
                    result += temp;
                }
            }
        }
        result+=T;
        return result;
    }
}
