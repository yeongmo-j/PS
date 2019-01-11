'''
[문제요약]
복소수 문자열 들어오면
실수부 허수부 나눠서 두개 곱해주기

[해결방법]
싹다 수동으로 했다.
a+bi의 형식이라 + 찾아서 그 앞뒤로 substring 해줬음.

Time complexity : O(1);
Space complexity : O(1)

[추가]
String y[] = b.split("\\+|i");
이렇게 스플릿 한걸 리스트에 넣을 수도 있고, 정규표현식으로 split 할 수 있다!!!!!!
'''

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int w, x, y, z;
        int temp;
        String result = "";
        temp = a.indexOf('+');
        w = Integer.valueOf(a.substring(0,temp));
        x = Integer.valueOf(a.substring(temp+1,a.length()-1));
        temp = b.indexOf('+');
        y = Integer.valueOf(b.substring(0,temp));
        z = Integer.valueOf(b.substring(temp+1,b.length()-1));
        result = "" +(w*y-x*z)+"+"+(w*z+x*y)+"i";
        return result;
    }
}
