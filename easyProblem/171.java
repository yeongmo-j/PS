'''
[문제요약]
알파벳으로 이루어진 문자열을 정수로 변환시키기
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
Input: "AB"
Output: 28
Input: "ZY"
Output: 701

[해결방법]
각 자리수는 26이 채워져야 풀임.
그러므로 다음 자리로 넘어가기 전에 26씩 곱해주기.

Time Complexity = O(N); N은 문자열의 길이.
Space Complecity = O(1);

[추가]

'''
class Solution {
    public int titleToNumber(String s) {
        int result=0;
        for (char c : s.toCharArray()){
            result*=26;
            result += c-'A'+1;
        }
        return result;
    }
}
