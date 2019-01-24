'''
[문제요약]
대문자가 제대로 쓰였는지.
이니셜만 대문자 혹은 전체다 대문자 혹은 전체다 소문자인지 확인

[해결방법]
일일이 확인했음.

[추가]
@@@@@좋은방법@@@@@
일단 대문자 개수를 다 세준다.

그다음에 한번에 판별.
그 값이 0이거나, 1이고 첫번쨰가 대문자거나, 길이와 같거나
면 true임.

또한 대문자 판별법도 좋은게
문자 - 'Z'가 0보다 작거나 같으면 대문자임.

public class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
}
'''

class Solution {
    public boolean detectCapitalUse(String word) {
        char[] str = word.toCharArray();
        int i;
        if (str[0]>='A' && str[0]<='Z'){
            if (str.length>=2 && str[1]>='A' && str[1]<='Z') {
                for (i=2 ; i<str.length ; i++){
                    if (str[i]>='a' && str[i]<='z')
                        return false;
                }
                return true;
            }
            else if  (str.length<2)
                return true;
            else{
                for (i=2 ; i<str.length ; i++){
                    if (str[i]>='A' && str[i]<='Z')
                        return false;
                }
                return true;
            }
        }
        else {
            for (i=0 ; i<str.length ; i++){
                if (str[i]>='A' && str[i]<='Z')
                    return false;
            }
            return true;
        }
    }
}
