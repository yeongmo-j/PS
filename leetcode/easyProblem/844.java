"
[문제요약]
문자열 2개가 들어오는데,
중간에 #은 백스페이스란 뜻임.
그대로 치고나서 두개가 같으면 t 아니면 f

[해결방법]
스택.

Time complexity : O(M+N);
Space complexity : O(M+N);

[추가]
그냥 내가 스택 만들지 말고
콜렉션으로 하자.
"
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int slen = S.length();
        int tlen = T.length();
        char[] first = new char[slen];
        char[] second = new char[tlen];
        int top1 = -1;
        int top2 = -1;
        char temp;
        for (int i=0 ; i<slen ; i++){
            temp = S.charAt(i);
            if (temp!='#')
                first[++top1]=temp;
            else{
                top1--;
                if(top1<-1)
                    top1=-1;
            }
        }
        for (int i=0 ; i<tlen ; i++){
            temp = T.charAt(i);
            if (temp!='#')
                second[++top2]=temp;
            else{
                top2--;
                if(top2<-1)
                    top2=-1;
            }
        }
        if(top1!=top2)
            return false;
        for (int i=0 ; i<=top1 ; i++){
            if (first[i]!=second[i])
                return false;
        }
        return true;
    }
}
