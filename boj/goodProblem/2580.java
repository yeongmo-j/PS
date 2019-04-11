"
[문제요약]
스도쿠 문제 풀기
9*9배열이 들어오고
0으로 들어온 원소들 다 채우기

[해결방법]
0으로 들어온 원소의 좌표들을 리스트에 추가해놓고
0인 원소 하나씩 앞에서부터 1~9씩 넣어보며 테스트 해보기.
테스트 통과 하면 다음꺼 채우기
즉, run(int n)은 n번째 0을 채우는 거임
성공하는 경우 list.size()<=n인경우 이 답을 복사해놓는다.
나머지 : 1~9까지 넣어보며, 테스트 해보고
 테스트 성공하면 run(n+1)로 넘겨주기
 루프 다 돌고나선, 전의 선택지로 복귀해야 하므로
 그 좌표의 값 0으로 돌려놓기

Time complexity : O(9^n); 여기서 n은 0의 개수
Space complexity : O(n)

[추가]

"
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	static int[][] sdoku;
	static LinkedList<int[]> zeros;
	static int[][] result;
	static int lastZero;

	static void run(int n) {
		//i번째 zero를 판별
		if (n>lastZero) {
			//프린트 & 끝
			copy();
			return;
		}
		int[] zero = zeros.get(n);
		for (int i=1 ; i<=9 ; i++) {
			sdoku[zero[0]][zero[1]] = i;
			if (test(zero[0],zero[1])) {
				run(n+1);
			}
			sdoku[zero[0]][zero[1]] = 0;
		}
	}

	static void copy() {
		if (result==null) {
			result = new int[9][9];
			for (int i=0; i <9 ; i++) {
				for (int j=0 ; j<9 ; j++)
					result[i][j] = sdoku[i][j];
			}
		}
	}

	static boolean test(int i, int j) {
		int starti = (i/3)*3;
		int startj = (j/3)*3;
		int originNum = sdoku[i][j];
		int count = 0;
		for (int k=0 ; k<3 ; k++) {
			for (int l=0 ; l<3 ; l++) {
				if (sdoku[starti+k][startj+l]==originNum)
					count++;
			}
		}
		if (count>1)
			return false;
		int counti=0, countj=0;
		for (int k=0 ; k<9 ; k++) {
			if (sdoku[k][j]==originNum)
				countj++;
			if (sdoku[i][k]==originNum)
				counti++;
		}
		if (counti>1 || countj>1)
			return false;
		return true;
	}

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scin = new Scanner(System.in);
		sdoku = new int[9][9];
		zeros = new LinkedList<>();
		int i, j;
		for (i=0 ; i<9 ; i++) {
			for (j=0 ; j<9 ; j++) {
				sdoku[i][j] = scin.nextInt();
				if (sdoku[i][j]==0) {
					int[] temp = {i, j};
					zeros.add(temp);
				}
			}
		}
		lastZero = zeros.size()-1;
		run(0);
		for (int[] row : result) {
			for (int elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}

	}
}
