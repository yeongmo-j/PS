"
[문제요약]
string 배열이 들어올 때,
각 배열 원소들의 접미사중에 공통된 최대 길이 접미사를 찾아라.

[해결방법]
자리수를 늘려가며 전체 배열을 살펴본다.

Time complexity : O(N) (전체 문자열의 문자개수)
Space complexity : O(N)

[추가]

"
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i=0, j=0;
        String result = "";
        char c;
        if (strs.length>0){
            while (true){
                if (i<strs[0].length())
                    c = strs[0].charAt(i);
                else
                    break;
                for (j=1 ; j<strs.length ; j++){
                    if (i<strs[j].length() && strs[j].charAt(i) == c) {}
                    else break;
                }
                if (j>=strs.length){
                    result += String.valueOf(c);
                    i++;
                }
                else
                    break;
            }
        }
        return result;
    }
}
