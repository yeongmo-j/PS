"
[문제요약]
왼쪽문자열이 오른쪽문자열의 원소들만을 이용해 만든건지?

[해결방법]
26짜리 정수 배열 만들고,
오른쪽 문자열 하나씩 세면서 문자 세기,
그다음에 왼쪽 문자열 하나씩 세면서 빼기
0보다 작아지면 false
끝까지 성공하면 true

Time complexity : O(N+M);
Space complexity : O(1)

[추가]

"
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char m : magazine.toCharArray())
            alphabet[(int)(m-'a')]++;
        for (char r : ransomNote.toCharArray()){
            if (--alphabet[(int)(r-'a')]<0)
                return false;
        }
        return true;
    }
}
