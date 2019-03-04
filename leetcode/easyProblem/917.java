'''
[문제요약]
문자열 주어지고,
알파벳인 것들만(특수문자빼고) 그 알파벳의 자리들에다가 역순으로 배치해서 리턴

[해결방법]
큐를 이용해서 뒤에서부터 알파벳 저장한다음에
앞에서부터 큐에서 빼서 저장

Time complexity : O(N);
Space complexity : O(N);

[추가]
Character.isLetter(c)
문자인지 알아보는법
'''
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] original = S.toCharArray();
        Queue<Character> queue = new LinkedList<Character>();
        int i;
        char temp;
        for (i=original.length-1 ; i>=0 ; i--){
            temp = original[i];
            if ((temp>='A'&&temp<='Z')||(temp>='a'&&temp<='z'))
                queue.add(temp);
        }
        for (i=0 ; i<original.length ; i++){
            temp = original[i];
            if ((temp>='A'&&temp<='Z')||(temp>='a'&&temp<='z'))
                original[i]=queue.poll();
        }
        return new String(original);
    }
}
