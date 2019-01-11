'''
[문제요약]
문자열 모스부호로 바꿔준다음에 중복되는거 찾기

[해결방법]
모스부호를 배열로 만들어준 다음에
알파벳(키)-모스부호(값)의 쌍으로 되는 해쉬맵을 사용해줬다.
문자열의 문자 하나하나당 모스부호로 바꿔준 결과값을
해쉬셋에 넣어주며 중복을 판단해줬다.

time complexity :
space complexity :

[추가]
굳이 해쉬맵 쓸 필요 없이
각 캐릭터에서 'a' 빼준 값으로 모스부호 배열의 인덱스로 사용해주면 되는 간단한 문제였다.
중복 판별은 해쉬셋으로 하는게 좋다.
'''

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character, String> hashmap = new HashMap<Character, String>();
        HashSet<String> hashset = new HashSet<String>();
        String temp;
        char chartemp;
        int count=0;
        for (int i=0 ; i<morse.length ; i++)
        {
            hashmap.put((char)(97+i),morse[i]);
        }
        for (String word : words)
        {
            temp = "";
            for (int j=0 ; j<word.length() ; j++)
            {
                chartemp = word.charAt(j);
                temp+= hashmap.get(chartemp);
            }
            if (!hashset.contains(temp))
            {
                count++;
                hashset.add(temp);
            }
        }
        return count;
    }
}
