"
[문제요약]
R*C배열로 롤러코스터가 지나간다.
각 칸을 지나갈때마다 점수를 얻고, 각 칸에서 상하좌우로 이동 가능 하다.
지나갔던 칸은 못지나간다.
이때, 가장 점수를 많이얻는 방법의 지나가는 경로를 출력하라 (LRUD 이걸로 여러개 붙여서 표현)
왼쪽위에서 시작해서 오른쪽아래에서 끝난다.

[해결방법]
몰라서 해설봄

일단, 가장 점수 많이 얻는 방법은 모든칸을 지나가는 방법이다.
만약 다 지나갈수 있다면, 그냥 오른쪽 쭉갔다가 내려오고, 왼쪽 쭉갔다가 내려오고
지그재그로 내려오며 다밟으면 된다.

그런데 그게 안될경우가 있음.
가로가 짝,홀수 + 세로가 짝,홀수
이 총 4경우를 살펴보자.
가로 세로 둘다 짝수일 경우에만 올 수 없다.
나머지는 그냥 지그재그 구현해주면 됨.
그럼 이제 문제는 짝수*짝수일 경우에 어딜 안지나가야 하냐? 이다.

왜 짝수짝수가 안되는지부터 생각해보자.
롤러코스터 칸을 체스판이라고 생각하고, 인접한것끼리 색깔 다르게 흑,백으로 나눠보자.
이렇게되면 처음과 시작 둘다 같은색이 되버린다.
칸이 짝수이기 때문에 백으로 시작해서 백->흑 / ->백->흑 / 이렇게 짝지으며 내려올 수 있는데,
이는 백->흑 에서 끝이 나야 한다. 그런데 끝은 백이므로 짝이 안맞는다.
이래서 짝*짝은 절대 불가능한 것이다.
그렇다면 어떤걸 안지나야 하냐? 흑색을 하나 빼줘야 한다.
그래야 지나 갈 수 있음.

그래서 체스판에서 시작,끝과 다른 칸 중에 최소값을 찾아서 그칸을 안지나오면 된다.
(좌표의 i+j가 홀수면 인 칸 중에 최소인 값을 안지나가면 됨)

이제 칸을 골랐으니 경로를 구현해주면 된다.
[00][01][02]
[10][11][12]
[20][21][22]
가 있을때 만약, 00에서 자기행과 자기아래행중에 안지나가는 칸이 있으면
00 01 02 12 11 10 20 으로 올 수 있다.
이걸 가능할때까지 반복한다.

그리고 끝점(오른쪽아래) 에서부터 올라오는것도 반복해준다.

그렇다면, 두줄이 남게된다.
두 행중에 한칸에는 안지나가는 칸이 있고,
왼쪽위는 시작, 오른쪽 아래는 끝이다.
이걸 열을 2칸씩 좁혀주는걸 반복해주면,
ㅁ ㅁ
ㅁ ㅁ 이렇게 네칸이 남고, 01, 10 둘중에 하나가 안지나가는 칸이 된다.

이렇게 지나가는 경로를 출력해주면 됨 (뒤에서부터 온건 뒤집고, L<->R D<->U 바꿔줘야 함)

Time complexity : O(R*C)
Space complexity : O(R*C)

[추가]
매우 좋은 문제라고 생각.

"

package test;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        int R = scin.nextInt();
        int C = scin.nextInt();
        int[][] map = new int[R][C];
        int i, j;
        int minI=0, minJ=0;
        int min = Integer.MAX_VALUE;
        for (i=0 ; i<R ; i++) {
        	for (j=0 ; j<C ; j++) {
        		map[i][j] = scin.nextInt();
        		if ((i+j)%2==1) {
        			if (map[i][j]<min) {
        				minI = i;
        				minJ = j;
        				min = map[i][j];
        			}
        		}
        	}
        }
        if (R%2==0 && C%2==0) {
        	//map[minI][minJ]를 뺌
        	i=0;
        	StringBuffer stringFront = new StringBuffer(R*C);
        	StringBuffer stringBack = new StringBuffer(R*C);
        	while (i+1<minI) {
        		for (j=0 ; j<C-1 ; j++)
        			stringFront.append('R');
        		stringFront.append('D');
        		for (j=0 ; j<C-1 ; j++)
        			stringFront.append('L');
        		stringFront.append('D');
        		i+=2;
        	}
        	i=R-1;
        	while (i-1>minI) {
        		for (j=0 ; j<C-1 ; j++)
        			stringBack.append('L');
        		stringBack.append('U');
        		for (j=0 ; j<C-1 ; j++)
        			stringBack.append('R');
        		stringBack.append('U');
        		i-=2;
        	}
        	i=0 ;
        	while (i+1<minJ) {
        		stringFront.append("DRUR");
        		i+=2;
        	}
        	i=C-1;
        	while (i-1>minJ) {
        		stringBack.append("ULDL");
        		i-=2;
        	}
        	if (minI%2==0)
        		stringFront.append("DR");
        	else
        		stringFront.append("RD");
        	stringBack.trimToSize();
        	for (i=stringBack.length()-1 ; i>=0 ; i--) {
        		char c = stringBack.charAt(i);
        		switch(c) {
        		case 'U' :
        			stringFront.append('D');
        			break;
        		case 'D' :
        			stringFront.append('U');
        			break;
        		case 'L' :
        			stringFront.append('R');
        			break;
        		case 'R' :
        			stringFront.append('L');
        		}
        	}
        	System.out.println(stringFront);
        } else {
        	StringBuffer string = new StringBuffer(R*C);
        	if (R%2==0) {
        		i=0;
        		while (i+1 < C-1) {
        			for (j=0 ; j<R-1 ; j++)
        				string.append('D');
        			string.append('R');
        			for (j=0 ; j<R-1 ; j++)
        				string.append('U');
        			string.append('R');
        			i+=2;
        		}
        		for (j=0 ; j<R-1 ; j++)
        			string.append('D');

        	} else {
        		i=0;
        		while (i+1<R-1) {
        			for (j=0 ; j<C-1 ; j++)
        				string.append('R');
        			string.append('D');
        			for (j=0 ; j<C-1 ; j++)
        				string.append('L');
        			string.append('D');
        			i+=2;
        		}
        		for (j=0 ; j<C-1 ; j++)
        			string.append('R');
        	}
        	System.out.println(string);
        }
        scin.close();
    }
}
