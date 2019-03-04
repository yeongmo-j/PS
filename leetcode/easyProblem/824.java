'''
[문제요약]
문자열 가지고 놀기.

[해결방법]

Time complexity : O(N); N은 단어의 개수.
Space complexity : O(1);

[추가]
'''
class Solution {

    boolean isVowel(String s)
    {
        char initial = s.charAt(0);
        if (initial=='a'||initial=='e'||initial=='i'||initial=='o'||initial=='u'||initial=='A'||initial=='E'||initial=='I'||initial=='O'||initial=='U')
            return true;
        return false;
    }

    public String toGoatLatin(String S) {
        String result;
        String output="";
        int a = 1;
        int i;
        String[] list = S.split(" ");
        for (String str : list){
            if (!isVowel(str)){
                result = str.substring(1);
                result += String.valueOf(str.charAt(0));
            }
            else
                result=str;
            result = result+"ma";
            for (i=0 ; i<a ; i++)
                result+="a";
            a++;
            output+=result+" ";
        }
        output = output.substring(0,output.length()-1);
        return output;
    }
}
