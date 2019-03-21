"
[문제요약]
정수 배열이 들어오는데,
이 수들을 두개씩 묶거나, 하나씩 묶어서
각 묶은 수들끼리 곱한 거를 더해서 가장 큰 수를 만들어라.

[해결방법]
일단 양수 기준으로 설명하면
가장 큰 수 두개씩 곱하는게 최적이다.
이유는 j-1<j<...<n-1<n으로 정렬된 배열이 들어올 떄
두개씩 묶은게 최적이라고 가정하고, j와 n-1을 바꿔서 곱한건 최적이 아님을 증명하면 된다
(앞에더 크단걸 증명.)
여기서 중요한 점.
양수와 음수를 나누긴 해야한다.
또 1을 처리 할 때 1*n = n < 1+n이므로 1은 묶지 말고 그냥 더하는게 이득이다.
그러므로 1은 따로 빼서 그냥 더해준다.
0도 따로 빼준다.
이렇게 양수와 음수를 따로 나눠서 받은 다음에, 정렬해주고 양수리스트를 뒤집어주면
절대값이 큰수에서 작은수로 정렬되어있다.
만약 양수들이 홀수개라면, 그 리스트에 1을 더해주면, 나머지 하나에 1을 곱해
자기 자신을 더하게 만들 수 있다.
만약 음수들이 홀수개라면, 나머지 하나를 저장해둔 0을 통해 없애 줄 수 있다.
만약 0이 한번도 안나왔더면, 그냥 1을 더해 그 수 자체를 더하게 만든다.
이제 2개씩 짝지어서 곱해서 더해주면 된다.

Time complexity : O(N)
Space complexity : O(N)

[추가]
"


import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        LinkedList<Integer> plus = new LinkedList<Integer>();
        LinkedList<Integer> minus = new LinkedList<Integer>();
        int one = 0;
        int zero = 0;
        int i = N;
        while (--N>=0){
            int num = scin.nextInt();
            if (num==0)
                zero++;
            else if (num==1)
                one++;
            else if (num>0)
                plus.add(num);
            else
                minus.add(num);
        }
        Collections.sort(plus);
        Collections.sort(minus);
        Collections.reverse(plus);
        if (plus.size()%2==1)
            plus.add(1);
        if (minus.size()%2==1)
            minus.add(zero>0 ? 0 : 1);
        for (i=0 ; i<plus.size() ; i+=2)
            one += plus.get(i)*plus.get(i+1);
        for (i=0 ; i<minus.size() ; i+=2)
            one += minus.get(i)*minus.get(i+1);
        System.out.println(one);
        scin.close();
    }
}
