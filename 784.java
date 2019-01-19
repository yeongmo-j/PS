'''
[문제요약]
문자열 하나 주어지고,
그중에서 알파벳인것들의 모든 대문자, 소문자 조합을 구해라.

[해결방법]
하나하나 바꿔줘가며 재귀.

Time complexity : O(2^N) N은 알파벳의 개수.
Space complexity : O(2^N);

[추가]
아예 맨처음 인자로 배열을 만들어서 전달해주면 훨씬 깔끔했을 듯 하다.
Character.toLowerCase(chars[index])
Character.toUpperCase(chars[index])
로 해주면 더 간편하다.

'''
class Solution {
    List<String> list;

    void perm(String S, int i)
    {
        if (i<S.length()){
            char c = S.charAt(i);
            String original = new String(S);
            if ((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                perm(S,i+1);
                if (c>='A'&&c<='Z'){
                    char[] initial = new char[1];
                    initial[0] = (char)(S.charAt(i) + ('a'-'A'));
                    String temp = "";
                    if (i>=1)
                        temp = S.substring(0,i);
                    temp += new String(initial);
                    if (i+1<S.length())
                        temp += S.substring(i+1);
                    perm(temp, i+1);
                }
                else{
                    char[] initial = new char[1];
                    initial[0] = (char)(S.charAt(i) + ('A'-'a'));
                    String temp = "";
                    if (i>=1)
                        temp = S.substring(0,i);
                    temp += new String(initial);
                    if (i+1<S.length())
                        temp += S.substring(i+1);
                    perm(temp, i+1);
                }
            }
            else {
                perm(S,i+1);
            }
        }
        else{
            list.add(S);
        }
    }

    public List<String> letterCasePermutation(String S) {
        list = new LinkedList<String>();
        perm(S,0);
        return list;
    }
}
