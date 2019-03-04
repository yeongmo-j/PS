"
[문제요약]
문자열 2개가 들어오는데,
타자 꾹 누르고 있는것처럼 a -> aaaaaa 이렇게 가능함.
그래서 왼쪽 문자 몇개 꾹눌러서 오른쪽문자 만들기 가능하면 true, 아니면 false

[해결방법]
둘다 맨앞에서부터 탐색하며,
한문자 나오면, while문으로 같은문자 연속으로 몇갠지 개수 세서,
왼쪽께 더 많으면 false

그리고, 마지막에 쓸대없는 문자가 들어가 끝날 수도 있으므로,
하나는 범위 넘었는데 하나는 범위 안넘었으면 false

Time complexity : O(N+M);
Space complexity : O(1);

[추가]
"
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0, nameLen=name.length(), typeLen = typed.length();
        int count1, count2;
        char n, t;
        while(i<nameLen || j<typeLen){
            if ((i>=nameLen && j<typeLen)||(i<nameLen && j>=typeLen))
                return false;
            count1=0;
            count2=0;
            n=name.charAt(i);
            t=typed.charAt(j);
            if(n!=t)
                return false;
            while (i<nameLen && name.charAt(i)==n){
                i++;
                count1++;
            }
            while ( j<typeLen && typed.charAt(j)==t){
                j++;
                count2++;
            }
            if (count1>count2)
                return false;
        }
        return true;
    }
}
