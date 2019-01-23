'''
[문제요약]
키보드 맨위, 중간, 아래 행이 있는데, 그중 하나의 행으로만 칠 수 있는 문자열 찾기

[해결방법]
주먹구구.

Time complexity : O(N) : N은 모든 문자열의 문자의 개수의 총 합
Space complexity : O(N)

[추가]
매번 대소문자 판별하지 말고
애초에 문자를 소문자로 바꿔놓고 시작하자!!

'''


class Solution {
    public String[] findWords(String[] words) {
        int[] keyboard = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<String>();
        int i, size, first;
        for (String word : words)
        {
            char[] wordArr = word.toCharArray();
            size = wordArr.length;
            if (wordArr[0]-'a'<0)
                first = keyboard[(int)(wordArr[0]-'A')];
            else
                first = keyboard[(int)(wordArr[0]-'a')];
            for (i=1 ; i<size ; i++)
            {
                if (wordArr[i]-'a'<0)
                {
                    if (keyboard[(int)(wordArr[i]-'A')]!= first)
                        break;
                }
                else
                {
                    if (keyboard[(int)(wordArr[i]-'a')]!= first)
                        break;
                }
            }
            if (i>=size)
                list.add(word);
        }
        int N = list.size();
        String[] arr = new String[N];
        for (i=0 ; i<N ; i++)
            arr[i]=list.get(i);
        return arr;
    }
}
