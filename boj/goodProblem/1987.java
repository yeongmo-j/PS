"
[문제요약]
r*c 배열이 들어오고, 각 원소에는 알파벳이 할당되어 있다
0,0에서 시작해서, 상하좌우 4방향으로 이동 할 수있을 때,
지금까지 밟아온 알파벳은 밟을 수 없다.
이 때, 이동할 수 있는 최대 거리를 구하여라

[해결방법]
재귀함수를 만든다. run(String route, int i, int j)
의 의미는 지금 [i][j]를 살펴보는데 ,지금까지 모은 알파벳은 route이다.

종료조건 : route에 arr[i][j]가 포함되어 있거나, i또는 j가 범위를 넘을 때,
route의 길이를 계산해주면 된다.

종료조건이 아니라면, route에다가 arr[i][j]를 더해주고,
4방향으로 보내주면 된다.

Time complexity : O(4^(r*c));
Space complexity : O(r*c)

[추가]

"
import java.io.IOException;
import java.util.Scanner;

public class Main{
	static char[][] arr;
	static int[][] direction = {{1,-1,0,0}, {0,0,1,-1}};
	static int r;
	static int c;
	static int max;

	static boolean contains(String str, char c) {
		for(char temp : str.toCharArray()) {
			if (temp==c)
				return true;
		}
		return false;
	}

	static void run(String route, int i, int j) {
		//지금 arr[i][j]를 살펴보고 있고, 지금ㅁ까지 모은 알파벳은 route임
		if (i<0 || i>=r || j<0 || j>=c || contains(route, arr[i][j])) {
			max = Integer.max(max, route.length());
			return;
		}
		for (int k=0 ; k<4 ; k++) {
			int nexti = i+direction[0][k];
			int nextj = j+direction[1][k];
			run(route+arr[i][j], nexti, nextj);
		}
	}


	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scin = new Scanner(System.in);
		r = scin.nextInt();
		c = scin.nextInt();
		arr = new char[r][c];
		max = Integer.MIN_VALUE;
		int i, j;
		for (i=0 ; i<r ; i++) {
			String temp = scin.next();
			for (j=0 ; j<c ; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		run("", 0, 0);
		System.out.println(max);
	}
}
