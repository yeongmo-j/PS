"
[문제요약]
문자열 두개 들어오고, 두개가 아나그람인지 확인
(두개 알파벳 집합이 서로 같은지?)

[해결방법]
문자열 원소 하나하나 탐색하며 크기 26짜리 배열에 개수 세고
두번째꺼는 개수를 빼준다.
이제 26짜리 배열 탐색하며 0아닌거 하나라도 있으면 false

Time Complexity = O(N); N은 문자열의 길이.
Space Complecity = O(1);

[추가]

"
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[(int)(c-'a')]++;
        for (char c : t.toCharArray())
            arr[(int)(c-'a')]--;
        for (int a : arr){
            if (a!=0)
                return false;
        }
        return true;
    }
}e
