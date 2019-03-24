"
[문제요약]
행렬 A와 B를 뒤집을 때,
A의 원소에서 3*3씩을 반전시켜(1은 0으로, 0은 1로)
두 행렬을 같게 만들고 싶다.
이때, 반전시키는 회수의 최소를 구하여라.

[해결방법]
몰라서 해설봄

일단, 똑같은 자리에 두번 연산을 할 필요는 없다.
그렇다면 다 한번씩 해본다고 할 때, 시간은 O(2^(N*M))이 되므로, 이는 절대 풀지 못한다.

그렇다면 일단  제일 왼쪽 귀퉁이를 살펴보자. 제일 왼쪽 귀퉁이를 바꿀 수 있는건
1,1을 기준으로 반전시키는 방법밖에는 없다. 이걸 한번 실행시킨다.
그렇다면 이제 그 옆칸을 살펴보자 (0,1)
여기를 바꿀 수 있는방법은 이미 실행시킨 0,0과 함께 반전시키는 방법을 제외하면, 1,2를 기준으로
반전시키는 방법밖에는 남지 않는다.
이런식으로 연속해서 살펴보면,
0~N-3, 0~M-3이 서로 같지 않으면, 반전시켜 주면 되고,
루프로 (N-2)(M-2)번만 돌아서 확인해주면 된다.


Time complexity : O(NM)
Space complexity : O(NM)

[추가]
매우 좋은 문제라고 생각.

"
import java.util.Scanner;

public class Main{

	static int[][] A;
	static int[][] B;

	static void change(int a, int b) {
		for (int i=-1; i<=1 ; i++) {
			for (int j=-1 ; j<=1 ; j++) {
				B[a+i][b+j] = B[a+i][b+j]==1 ? 0 : 1;
			}
		}
	}

    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);

        int N = scin.nextInt();
        int M = scin.nextInt();
        int i, j;
        A = new int[N][M];
        B = new int[N][M];

        for (i=0 ; i<N ; i++) {
        	String temp = scin.next();
        	for (j=0 ; j<M ; j++) {
        		A[i][j] = (int)(temp.charAt(j)-'0');
        	}
        }

        for (i=0 ; i<N ; i++) {
        	String temp = scin.next();
        	for (j=0 ; j<M ; j++) {
        		B[i][j] = (int)(temp.charAt(j)-'0');
        	}
        }
        int count=0;
        for (i=0 ; i<N-2 ; i++) {
        	for (j=0 ; j<M-2 ; j++) {
        		if (A[i][j] != B[i][j]) {
        			count++;
        			change(i+1, j+1);
        		}
        	}
        }

        for (i=0 ; i<N ; i++) {
        	for (j=0 ; j<M ; j++) {
        		if (A[i][j]!=B[i][j]) {
        			count = -1;
        			break;
        		}
        	}
        	if (count==-1)
        		break;
        }

        System.out.println(count);

        scin.close();
    }
}
