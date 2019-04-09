"
[문제요약]
n개의 마을이 있고 각 마을에서 마을로 이동하는데 걸리는 시간이
n*n로 주어질 때, a[i][j]는 i에서 j로 이동하는데 걸리는 시간
전체 마을을 1번씩 들러서, 원래의 마을로 돌아올 때, 가장 적게 걸리는 시간을 구하여라.

[해결방법]
일단 n이 10이 넘으면 숫자가 너무 커짐으로, n!의 모든 경우의 수를 탐색 불가능하다
그런데 숫자가 작으므로 전체 탐색 가능.
n!만큼 순열을 하나씩 다 구해준다음에, 걸리는 시간 계산해보자.
모든 경우의수 조합해본다음에, 계산

Time complexity : O(n!*n) n!개수에 계산하는데 n
Space complexity : O(n)

[추가]
이렇게 범위가 좁을 경우엔 다 해보자
@@@@@이문제를 잘 살펴보면
1-2-3-4
2-3-4-1
3-4-1-2
4-1-2-3
이 다 같은걸 알 수 있다
왜냐면 원래 도시로 돌아와야 하기 떄문에.
그러므로 첫번째 도시를 고정! 시켜놓은다음에
그 뒤에있는거만 풀어줘도 된다
즉
(n-1)! * n!번만 해도 되는것!
(n분의1로 줄어듬)
"
import java.io.IOException;
import java.util.Scanner;

public class Main{
	static int n;
	static int[] arr;
	static int min;
	static int[][] map;

	static int calculate() {
		int sum=0;
		for (int i=0 ; i<=n-2 ; i++) {
			if (map[arr[i]][arr[i+1]]==0)
				return Integer.MAX_VALUE;
			sum+=map[arr[i]][arr[i+1]];
		}
		if (map[arr[n-1]][arr[0]] ==0)
			return Integer.MAX_VALUE;
		sum+=map[arr[n-1]][arr[0]];
		return sum;
	}

	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void run(int startIdx) {
		if (startIdx==n-1) {
			min = Math.min(min, calculate());
		} else {
			for (int i=startIdx ; i<n ; i++) {
				swap(startIdx, i);
				run(startIdx+1);
				swap(startIdx, i);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Scanner scin = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = scin.nextInt();
		arr = new int[n];
		map = new int[n][n];
		min = Integer.MAX_VALUE;
		int i, j;
		for (i=0 ; i<n ; i++) {
			arr[i] = i;
			for (j=0 ; j<n ; j++)
				map[i][j] = scin.nextInt();
		}
		run(0);
		System.out.println(min);

	}
}
