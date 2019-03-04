'''
[문제요약]
문자열 배열과 패턴 문자열이 주어질 때,
문자열 배열의 원소 중에서 패턴과 일치하는 것들만 골라내는 거
"mee"와 "abb"는 일치한다

[해결방법]
주먹구구식 해결
각 스트링 두개에 대응하는 해쉬맵 만들어준 뒤에,
새로운 character가 나올 때마다 맵에 추가해주고, a부터 하나하나씩 값으로 추가해준다.
앞에 나왔던거면, 맵에서 꺼내와서 result에다가 추가해준다.
이렇게 반복하다 보면 결국 a부터 시작되는 패턴으로 완성된다.

이걸 각각 두개씩 해준다음에
result 두개가 각각 같은 문자열인지 확인해주면 된다.

Time complexity : O(N*M) N은 배열의 크기, M은 문자열의 크기
Space complexity : O(M) : 문자열의 크기 (루프 돌때마다 map이 리셋되는데 ,이걸 무시해도 되는가?
무시하면 안되면 N*M이다.)

[추가]
for each안에 각 문자열 원소마다 비교하는 대신
그걸 밖으로 메소드로 빼줘서 string,string을 인자로 갖는 메소드로 만들어주면
더 간단 해진다.

방법은 비슷한데
더 좋은방법!
원소 하나씩 비교해가며 map에 없으면? 상대편 원소를 값으로 넣어준다!

그 다음에 첫번째꺼(첫번째원소)!=두번째원소 or 두번째꺼(두번째원소)!=첫번째원소
이면 false임.

두개씩 짝지어준다음에
다음에 그 짝과 다른게 올라오면 틀렸다고 하면 된다!
어차피 패턴이 다르면 따른 결과가 나오므로 마지막에 비교해줄 필요가 없어짐.
'''


class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<String>();
        Map<Character, Character> mapFirst;
        Map<Character, Character> mapSecond;
        int countFirst, countSecond;
        int size = pattern.length();
        String resultFirst;
        String resultSecond;
        for (String word : words)
        {
            mapFirst = new HashMap<Character, Character>();
            mapSecond = new HashMap<Character, Character>();
            countFirst= 0;
            countSecond = 0;
            resultFirst = "";
            resultSecond = "";
            for (int i=0 ; i<size ; i++)
            {
                if (!mapFirst.containsKey(word.charAt(i)))
                {
                    mapFirst.put(word.charAt(i),(char)('a'+countFirst));
                    resultFirst += String.valueOf((char)('a'+countFirst));
                    countFirst++;
                }
                else
                {
                    resultFirst += String.valueOf(mapFirst.get(word.charAt(i)));
                }
                if (!mapSecond.containsKey(pattern.charAt(i)))
                {
                    mapSecond.put(pattern.charAt(i),(char)('a'+countSecond));
                    resultSecond += String.valueOf((char)('a'+countSecond));
                    countSecond++;
                }
                else
                {
                    resultSecond+= String.valueOf(mapSecond.get(pattern.charAt(i)));
                }
            }
            if (resultFirst.equals(resultSecond))
                list.add(word);
        }
        return list;
    }
}
