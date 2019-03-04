'''
[문제요약]
문자열 두개 주어지고,
1번에 있는 모든 알파벳은 2번에 똑같은 개수대로 있고, 단 하나만 추가되었다. 그 하나를 찾으라

[해결방법]
26짜리 배열 하나 만들고,
1번 문자열 배열로 만들어서 하나하나 갯수 세 준다음에
2번 문자열 배열로 만들어서 갯수 세면서 빼준다.
-1 되는 순간 그 문자 리턴

Time complexity : O(N); 길이
Space complexity : O(1);

[추가]
@@@@@@
예전에 했던것처럼
xor 비트 연산 해주기!!!!!
마지막에 남는게 답이다!
^=로!
'''
더 좋은거
public char findTheDifference(String s, String t) {
	int n = t.length();
	char c = t.charAt(n - 1);
	for (int i = 0; i < n - 1; ++i) {
		c ^= s.charAt(i);
		c ^= t.charAt(i);
	}
	return c;
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] original = new int[26];
        for (char c : s.toCharArray()){
            original[(int)(c-'a')]++;
        }
        for (char c : t.toCharArray()){
            original[(int)(c-'a')]--;
            if (original[(int)(c-'a')]<0)
                return c;
        }
        return '0';
    }
}
