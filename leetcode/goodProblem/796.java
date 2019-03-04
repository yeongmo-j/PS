"
[문제요약]
문자열 2개가 주어지고,
두개가 서로 기차놀이처럼 순서가 같은 경우, 앞에있는원소들을 차례대로 맨뒤로 갖다붙이는 행위를
몇번 했을 때, 두 문자열이 같아지면 true 아니면 false.

[해결방법]
하나씩 다 해봤다.
맨 앞글자 같을때까지 탐색 한 뒤에, 같으면 그 뒤에꺼까지 다 탐색한다.

Time complexity : O(N^2);
Space complexity : O(N);

[추가]
일단 A=A+A를 하면
똑같은게 2번 반복되는 문자열이 되고,
이 안에는 B가 무조건 존재하게 된다.
이때 A+A에서 B가 존재하는지, 검색 하면 된다.
검색 할 때 contains를 쓰던지,
더 빠르게 하려면 KMP를 사용한다!
"
class Solution {
    public boolean rotateString(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if (lenA!=lenB)
            return false;
        if (lenA==0 && lenB==0)
            return true;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int i=0, j;
        for (i=0 ; i<lenB ; i++){
            if (b[i]==a[0]){
                for (j=0 ; j<lenA ; j++){
                    if (b[(i+j)%lenB]!=a[j])
                        break;
                }
                if (j>=lenA)
                    return true;
            }
        }
        return false;
    }
}
