"
[문제요약]
출석현황 문자열이 주어지는데, 결석 2번 이상이거나 지각 3번이상 연속이면 false

[해결방법]
해봤음.

Time complexity : O(N);
Space complexity : O(1);

[추가]
일단 내가 한방법은 너무 별로임.
public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
}
정규표현식으로도 끝낼 수 있고,

public class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}
이렇게도 쓸 수 있다.
@@@@2개 이상인지 알아보기 = 인덱스앞에서, 뒤에서 두번 찾아서 같은지 확인하기!!!!!!@@@@@
"
class Solution {
    public boolean checkRecord(String s) {
        int abs=0;
        int lateIdx = -10;
        int lateCount = 0;
        char[] arr = s.toCharArray();
        for (int i=0 ; i<arr.length ; i++){
            if (arr[i]=='A'){
                abs++;
                if (abs>=2)
                    return false;
            }
            else if (arr[i]=='L'){
                if (lateIdx==i-1){
                    lateCount++;
                    if (lateCount>=3)
                        return false;
                }
                else
                    lateCount=1;
                lateIdx = i;
            }
        }
        return true;
    }
}
