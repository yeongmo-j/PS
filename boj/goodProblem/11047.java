"
[문제요약]
동전의 개수 N개와 각 동전의 단위가 들어올 떄,
K원을 동전 최소로 써서 만들어라.
단 조건 첫번째동전은 1원이며, 다음 동전은 그 전 동전의 배수이다.

[해결방법]
이걸 d[i] = i원을 만들 수 있는 최소 동전의 개수로 dp로 풀었더니 시간초과 뜸

조건을 유심히 살펴보자.
첫번째 동전 1원 : 다 만들 수 있다.
그 다음동전이 전동전의 배수이다 : 전 동전 여러개면, 그걸 모아서 그 다음 큰 동전
만들 수 있다. -> 작은동전 여러개 쓰는거보다 큰동전 하나쓰는게 무조건 이득이다

그러므로 큰동전부터 계속 살펴보며 만들어 나간다.

Time complexity : O(N) (동전의 가지수)
Space complexity : O(N)

[추가]
이렇게 동전이 배수면, 그리디 알고리즘이다!
"

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        int K = scin.nextInt();
        int[] coin = new int[N+1];
        int i;
        for (i=1 ; i<=N ; i++) {
        	coin[i] = scin.nextInt();
        }
        int count=0;
        for (i=N ; i>=1 ; i--) {
        	if (coin[i]<=K) {
        		int num = K/coin[i];
        		K-=coin[i] * num;
        		count+=num;
        	}
        }
        System.out.println(count);
        scin.close();
    }
}
