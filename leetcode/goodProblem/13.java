'''
[문제요약]
로마자 문자열이 들어오고, 이걸 정수로 바꿔라.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
각 이렇게 해당되고,
For example, two is written as II in Roman numeral,
just two one\'s added together.
Twelve is written as, XII,which is simply X + II.
The number twenty seven is written as XXVII, which is XX + V + II.

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

[해결방법]
일단 하나씩 뒤로 전진해가며 값을 저장한다.
똑같은게 나오면 계속 그 값을 증가시키며 저장하다가,
다른게 나타나면 ,그때부터 판별시작.
만약 앞에나온게 더 큰거면? 지금까지 저장한 수 정답에다 추가시킨다.
만약 뒤에나온게 더 큰거면? 앞의 수들을 빼준다. 그뒤 새로 시작.
문자와 숫자는 map으로 연결시킨다.

Time Complexity = O(N);
Space Complecity = O(1);

[추가]
1111000 이렇게 1과 0으로 있는문제에서 1과 0이 서로 붙어있고, 같은개수로 있는 substring의 개수를
찾는 문제와 비슷하게 접근을 해봤음.
'''
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] str = s.toCharArray();
        char pre=str[0];
        int result=0;
        int count=map.get(pre);
        for (int i=1 ; i<str.length ; i++){
            if (str[i-1]!=str[i]){
                if (map.get(str[i-1])>map.get(str[i]))
                    result+=count;
                else
                    result-=count;
                count=map.get(str[i]);
                pre = str[i];
            }
            else
                count += map.get(str[i]);
        }
        result += count;
        return result;
    }
}
