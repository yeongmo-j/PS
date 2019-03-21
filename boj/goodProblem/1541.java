"
[문제요약]
수식이 들어오는데, 수식은 +와 -로 이루어져 있다.
이 때, 괄호를 적절히 쳐서 최소값으로 만들어라

[해결방법]
- 뒤에 나오는걸 최소로 만들어야 하는데,
-뒤에 나오는건 다 음수로 만들 수가 있음.
왜냐면 1. -뒤에 다 +밖에 없다 : 다 괄호로 묶어서 -붙이면 음수됨
2. 뒤에 -가 섞여있다 : - 앞까지 묶어서 음수로 만든다음에 또 그 다음-에서 반복한다
이런식으로 첫번째 -만 찾으면, 그 뒤부턴 다 빼주면 된다.

앞에서부터 하나씩 살펴가며,
부호 넣는 리스트와 , 값 넣는 리스트 2개를 만들어서 하나씩 추가해준다
그 뒤, 맨 앞에 값은 무조건 +므로, 그 값으로 시작해서
1:1 매칭 해가다가 - 찾으면 그 뒤부터는 다 빼주면 됨.

Time complexity : O(N)
Space complexity : O(N)

[추가]
"

import java.util.Scanner;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        String str = scin.next();
        LinkedList<Character> sign = new LinkedList<Character>();
        LinkedList<Integer> num = new LinkedList<Integer>();
        char[] charArr = str.toCharArray();
        int now = 0;
        for (char c : charArr){
            if (c == '+' || c == '-'){
                sign.add(c);
                num.add(now);
                now = 0;
            } else {
                now*=10;
                now += (int)(c-'0');
            }
        }
        num.add(now);
        int result = num.get(0);
        for (int i=0, j=1 ; i<sign.size() && j<num.size() ; i++, j++){
            if (sign.get(i)=='+'){
                result += num.get(j);
            } else {
                while (j<num.size()){
                    result -= num.get(j);
                    j++;
                }
            }
        }
        System.out.println(result);
    }
}
