"
[문제요약]
1~T초까지 1초에 한번 자두가 떨어진다. 1번나무 / 2번나무 둘중 하나에서 떨어짐
밑에서 1초에 하나씩 떨어지는 자두를 받아먹음. W번 움직일 수 있고, 처음에 1번나무에 있다
이동은 진짜빨라서 그냥 나무 떨어지기 직전에도 빛의속도로 움직일 수 있음.
최대로 먹을 수 있는 자두의 개수를 구하여라(W번 움직일 수 있으니까 이게 제한임)
또 어느 시점에 어느나무에서 떨어질지도 주어짐.

[해결방법]
DP이용
d[i][j][k] : i번째시간 j개의 이동회수 남을때 k에 있을 경우에, 현재까지 먹을 수 있는 최대 개수
일단 arr[i+1]를 구해놓는다. 이게 다음에 떨어질 자두의 위치
d[i+1][j-1][3-k]는 이동 했을 경우. 이떄 3-k와 arr[i+1]를 비교해서 1을 더할지 말지 결정
d[i+1][j][k]는 이동하지 않았을 경우. 이때 k와 arr[i+1]를 비교해서 1을 더할지 말지 결정
이렇게 4개의 경우가 있다.
d[0][w][1] = 0으로 시작

Time complexity : O(t*w)
Space complexity : O(t*w)

[추가]
3차원 배열로 [k]를 만들지 말고,
(w-j)%2로 지금 위치가 어딘지 판별 할 수 있다!(남은 개수를 통해)
그러므로 그냥 계산 가능하다
2차원 배열로 줄일 수 있음
public static int go(int n, int m, int[] a, int[][] d, int pos, int turn) {
    if (pos == n+1 && turn <= m) {
        return 0;
    }
    if (turn > m) {
        return 0;
    }
    if (d[pos][turn] != -1) {
        return d[pos][turn];
    }
    int where = turn % 2 + 1;
    d[pos][turn] = Math.max(go(n,m,a,d,pos+1,turn), go(n,m,a,d,pos+1,turn+1)) + (where == a[pos] ? 1 : 0);
    return d[pos][turn];
}

이렇게 훨씬 짧아진다.
그대신 이때는 2번 호출해서 더 짧은거 구해야 함.
1에서 시작할 경우 1,0 / 2에서 시작할 경우 1, 1

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]);
		int w = Integer.parseInt(input[1]);
		int i, j, k;
		int[] jadu = new int[t+1];
		for (i=1 ; i<=t ; i++) {
			jadu[i] = Integer.parseInt(br.readLine());
		}
		int[][][] d = new int[t+1][w+1][3];
		//d[i][j][k] : i번째시간 j개의 이동회수 남을때 k에 있을 경우에, 현재까지 먹을 수 있는 최대 개수
		for (i=0 ; i<=t ; i++)
			for (j=0 ; j<=w ; j++)
				for (k=0 ; k<3 ; k++)
					d[i][j][k] = -1;
		d[0][w][1] = 0;
		for (i=0 ; i<t ; i++) {
			for (j=w ; j>=0 ; j--) {
				for (k=1 ; k<=2 ; k++) {
					int now = d[i][j][k];
					if (now == -1)
						continue;
					if (jadu[i+1]==k) {
						d[i+1][j][k]= Integer.max(d[i+1][j][k], now+1);
						if (j-1>=0)
							d[i+1][j-1][3-k] = Integer.max(d[i+1][j-1][3-k], now);
					}
					else  {
						d[i+1][j][k] = Integer.max(d[i+1][j][k], now);
						if (j-1>=0)
							d[i+1][j-1][3-k] = Integer.max(d[i+1][j-1][3-k], now+1);
					}
				}
			}
		}
		int max = -1;
		for (i=0 ; i<=w ; i++) {
			for (j=1 ; j<=2 ; j++)
				max = Integer.max(max, d[t][i][j]);
		}
		System.out.println(max);
	}
}
