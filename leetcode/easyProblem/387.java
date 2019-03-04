"
[문제요약]
문자열이 주어지고,
알파벳 하나만 존재하는걸 찾아라.
제일 앞에있는거의 인덱스를 리턴해라.
없으면 -1

[해결방법]
26짜리 배열만들어서 개수센다음에
앞에서부터 탐색해가며 그게 1번나오면 리턴

Time complexity : O(N);
Space complexity : O(1);

[추가]
"
class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        int i;
        char[] arr = s.toCharArray();
        for (char c : arr)
            alphabet[(int)(c-'a')]++;
        for (i=0 ; i<arr.length ; i++){
            if (alphabet[(int)(arr[i]-'a')]==1)
                return i;
        }
        return -1;
    }
}
