"
[문제요약]
character 배열이 들어오고, 타겟이 들어온다.
타겟보다 큰 것중에 제일 작은거 리턴하라.
없으면 맨앞에꺼 리턴.

[해결방법]
for each로 루프 돌려서 찾음.

Time complexity : O(N)
Space complexity : O(1);

[추가]
"
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters){
            if (c>target)
                return c;
        }
        return letters[0];
    }
}
