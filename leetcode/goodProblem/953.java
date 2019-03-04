'''
[문제요약]
새로운 알파벳 순열이 주어지고, 이걸 기준으로
주어진 단어 set이 사전순으로 잘 되어 있는지?

[해결방법]
하나하나 다 해봤음.
일단 단어 배열(input)기준 앞에 단어랑 비교해서, 틀리면 바로 false를 내도록
만약 맨앞글자가 같으면 뒷글자부터 계속.
종료조건 주의할것!!

Time complexity : O(N*M) N은 배열의 개수, M은 단어의 크기
Space complexity : O(1);

[추가]
종료조건 주의.
비교할때 한글자한글자 비교하다가 둘 중 하나의 끝에 다다르면 끝나는데
만약 비교하는 두 단어의 길이가 다르면,
더 짧은게 앞이다.

사전순으로 정렬 하는거 연습!
'''
class Solution {

    boolean isFront(String order, char first, char second)
    {
        return order.indexOf(first)<=order.indexOf(second);
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length<=1)
            return true;
        int i, j;
        char front, now;
        front = words[0].charAt(0);
        for (i=1 ; i<words.length ; i++)
        {
            now = words[i].charAt(0);
            if (front==now)
            {
                for (j=1 ; j<words[i-1].length() && j<words[i].length() ; j++)
                {
                    if (words[i-1].charAt(j)!=words[i].charAt(j))
                        if (isFront(order,words[i-1].charAt(j),words[i].charAt(j) ))
                            break;
                    else
                        return false;
                }
                if (words[i-1].length()>words[i].length())
                    return false;
            }
            else
                if (!isFront(order,front,now))
                    return false;
            front = now;
        }
        return true;
    }
}
