"
[문제요약]
여자 N 남자 M 인턴십참여하는사람 K
여자2명+남자1명이 한팀으로 대회 참여하는데
전체인원에서 k명은 인턴으로 빠져야한다.
이때 최대로 만들 수 있는 팀의 수

[해결방법]
총 K명이 빠지고, 여자에서 빠지는 사람으 ㅣ수를 i라고 할 때
팀의 수는
(N-i)/2와 M-(k-i) 중에서 더 작은거다
즉, i의범위를 0부터 K까지 바꿔가며 저 위의 값 중 제일 큰 값을 찾아주면 됨

Time complexity : O(K)
Space complexity : O(N)

[추가]
"


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        int M = scin.nextInt();
        int K = scin.nextInt();
        int i;
        int maximum = 0;
        for (i=0 ; i<=K ; i++) {
        	maximum = Integer.max( Integer.min((N-i)/2, M-(K-i)), maximum);
        }
        System.out.println(maximum);

        scin.close();
    }
}
