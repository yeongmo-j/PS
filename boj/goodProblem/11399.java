"
[문제요약]
ATM이 한대밖에 없어서 줄서서 사용하는데,
1번손님이 3 ,2번손님이 2, 3번손님이 1만큼 시간이 걸린다면
1번손님 3 + 2번손님(기다리는3+자기2) + 3번손님(기다리는 3+2+자기1) 만큼 총 시간이 걸리게 된다
총 시간 최소로 해서 결과

[해결방법]
시간이 누적되므로,
1번이 뽑는게 제일 적게걸려야지 조금누적된다.
즉 정렬해서 앞에서부터 시간 배정

Time complexity : O(NlgN) (정렬)
Space complexity : O(N)

[추가]
증명하는 방법
일단 비내림차순으로 정렬하는게 최적이라고 가정하면
i<j일 때 p1<=p2<=p3<=...<=pi<=pj<=...가 되고
n*p1 + (n-1)*p2 + ...+(n-i+1)*pi + (n-j+1)*pj가 최소이다.
이중에서 순서가 바뀌면 이보다 커져야 한다.
n*p1 .... + (n-i+1)pj + (n-j+1)pi +....가 더 커야 한다
이를 연산해주면
(i-j)(pj-pi)<=0이 되는데,
이는 참이 된다.(i<j, pi<=pj가정에 의해)
이렇게 증명을 해주자
@@@증명과정@@@@@
"
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        int[] P = new int[N];
        int i;
        for (i=0 ; i<N ; i++)
            P[i] = scin.nextInt();
        Arrays.sort(P);
        int result = 0;
        for (i=0 ; i<N ; i++){
            result += P[i]*(N-i);
        }
        System.out.println(result);
        scin.close();
    }
}
