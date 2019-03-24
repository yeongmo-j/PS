"
[문제요약]
나이트는 위2오1, 위1오2, 아래1오2, 아래2오1
이렇게 4조합으로만 움직일 수 있다.
가로 세로 길이 들어오고
왼쪽 아래에 나이트 위치해 있을 때,
한번의 게임에서 나이트가 최대로 닿을수 있는 칸의 개수를 구하여라
아, 4번 이상 움직일 때는 저기 나온거 한번씩은 다 써서 움직여야 한다.

[해결방법]
몰라서 해설봄

일단 경우의수를 나눠야 한다.
세로가 1일때 = 못움직임. 1

세로가 2일때 : 위한칸 아래한칸만 진동하며 움직여야 하는데,
최대 3번까지밖에 못움직임. 그러므로 (3번움직여서:4칸 / (N+1)/2) 중에 더 작은거 골라서 리턴

세로가 3 이상일 떄
이떄는 2개의 케이스로 나눠야 한다.
4번 이상 움직이려면 한번씩 다 써야하니까,
일단 한번씩 다 쓰고 시작하면, 제일 아래줄 7번째칸으로 이동된다.여기서부턴 자유인데, 최대한으로 움직이니까
오른쪽으로 한칸씩만 움직이면 최대다(위아래로 진동) : 4 + (N-6) = N-2가 된다. 이떄는 가로의 길이가 7 이상일때이다.

그렇다면 7 미만일때는, 3번이하로만 움직여야 하므로, N과 4중에서 더 작은걸 리턴하면 된다.

Time complexity : O(1)
Space complexity : O(N)

[추가]
입력이 둘다 20억으로 들어와서
절대 루프는 못돌림.

이렇게 큰수가 입력으로 들어오면 루프 돌리라는게 아니라 수식으로 풀라는 가능성이 매우 높음.

"
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int M = scin.nextInt();
        int N = scin.nextInt();
        int result = 0;
        if (M==1)
        	result = 1;
        else if ( M==2)
        	result = Integer.min((N+1)/2, 4);
        else {
        	if (N>=7)
        		result = N-2;
        	else
        		result = Integer.min(N, 4);
        }
        System.out.print(result);
        scin.close();
    }
}
