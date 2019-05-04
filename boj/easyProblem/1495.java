"
[문제요약]
volume[i]는 i번째 곡을 연주하기 전, 조절할 수 있는 볼륨의 크기이다.
즉 i-1번째 곡을 연주한 후에 볼륨이 x라면, i번째 곡은 x+volume[i] 혹은 x-volume[i]의 볼륨으로
연주를 할 수 있게 되는것이다.

만약 처음을 s로 시작하고, volume이 주어졌다면, 마지막 연주 시에, 최대 볼륨을 몇으로 만들 수 있는가?
중간에 볼륨 못바꾼다면, -1출력 (꼭 볼륨 바꿔야 함)

입력으로 몇곡인지 N과, 각 곡마다 바꿀수 있는 볼륨의 배열 volume과 시스템 최대 볼륨m과 시작볼륨 s가 주어진다.
0밑으로 못가고 m이상으로 못감

[해결방법]
d[i][j] = 만약 i번째 곡에 볼륨j를 만들 수 있으면 true, 아니면 false인 boolen 2차원 배열
d[0][s] = true로 시작해서
다음으로 바꿔나간다. (첫번쨰 곡에도 볼륨을 바꾸고 연주할 수 있기 떄문에 0부터 시작)

Time complexity : O(n*m)
Space complexity : O(n*m)

[추가]

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		int m = Integer.parseInt(input[2]);
		int[] volume = new int[n+1];
		int i, j;
		input = br.readLine().split(" ");
		for (i=1 ; i<=n ; i++)
			volume[i] = Integer.parseInt(input[i-1]);
		boolean[][]d = new boolean[n+1][m+1];
		d[0][s] = true;
		for (i=0 ; i<n ; i++) {
			for (j=0 ; j<=m ;j++) {
				if (d[i][j]) {
					int next=i+1;
					if (j+volume[next]<=m)
						d[next][j+volume[next]]=true;
					if (j-volume[next]>=0)
						d[next][j-volume[next]]=true;
				}
			}
		}
		int max = -1;
		for (i=0 ; i<=m ; i++) {
			if (d[n][i])
				max = i;
		}
		System.out.println(max);
	}
}
