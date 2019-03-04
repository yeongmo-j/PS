"
[문제요약]
7진법으로 바꿔라

[해결방법]

Time complexity : O(log_7^N);
Space complexity : O(1);

[추가]
"
class Solution {
    public String convertToBase7(int num) {
        boolean isMinus=false;
        if (num<0){
            num*=-1;
            isMinus = true;
        }
        if (num==0)
            return "0";
        String result = "";
        while (num!=0){
            result = num%7 + result;
            num/=7;
        }
        if (isMinus)
            result = "-"+result;
        return result;
    }
}
