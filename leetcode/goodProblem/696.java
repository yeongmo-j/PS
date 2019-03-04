'''
[문제요약]
1과 0으로 이루어진 문자열이 주어지고,
substring중에서 0과 1의 개수가 같은 개수를 구하라.
이때 1은 1끼리, 0ㅇ은 0끼리 붙어있어야 한다.
즉 1100은 되는데 1010은 안된다.

[해결방법]
직접 해보려다 이건 너무 느릴꺼 같아서 해설 확인했음.

Time Complexity = O();
Space Complecity = O();

[추가]
일단 currentRun과 preRun이라는 변수를 2개 갖고 시작한다.
currentRun은 지난번의 숫자가 몇개 나왔는지고,
preRun은 지금 탐색하는 숫자가 연속적으로 몇개나왔는지를 알려주는 변수다.
시작은 preRun=0로 시작하고,currentRun도 1로 시작한다.(첫번쨰꺼는 내가 셌음)
그다음부턴 인덱스 1부터 탐색을 시작하는데
s[i-1]과 s[i]가 다르면, cur의 값을 pre로 옮기고 ,cur은 1로 바꾼다.
같으면, cur의 값을 1씩 증가시킨다.

이 작업 후에, 공통적으로 pre와 cur를 비교해주는데, pre가 같거나 더 많으면, 카운트를 1씩 해준다.
그 이유는 0000000001일 시에, 1이 하나씩 늘어날 때마다 부분집합도 하나씩 늘어나기 떄문이다.
00000001 :1개
000000011 : 2개
0000000111 : 3개.

좋은 문제라고 생각.


'''
class Solution {
    public int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        int i, len = c.length;
        int currentRun=1, preRun = 0;
        int count=0;
        for (i=1 ; i<len ; i++){
            if (c[i-1]!=c[i]){
                preRun=currentRun;
                currentRun=1;
            }
            else
                currentRun++;
            if (preRun>=currentRun){
                count++;
            }
        }
        return count;
    }
}
