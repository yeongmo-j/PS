"
[문제요약]
k개의 숫자가 들어오는데,
이를 2개를 합쳐 하나로 만들 수 있다.
이렇게 2개씩 합쳐가서 최종 하나로 만들 떄의 최소 비용을 구하라.
만약 10하고 20을 합치면 30이 비용이다.
40 30 30 50을 합치면
30 30 = 60으로 합치고
60 40 = 100으로 합치고
100 50 = 150으로 합치면 하나가 된다
여기서 비용은 60 + 100 + 150 = 310이다 (최소아님)
이게 최소가 되게 구해야 함


[해결방법]
DP이용
c[i][j]는 i에서 j까지의 전체 크기 합 (단순 합)
int[][]c = new int[k][k];
for (i=0 ; i<k ; i++) {
    c[i][i] = arr[i];
    for (j=i+1 ; j<k ; j++) {
        c[i][j] = c[i][j-1]+arr[j];
    }
}

d[i][j]는 i에서 j까지를 하나로 합칠때 드는 최소 비용
d[i][j] = d[i][k] + d[k+1][j] + c[i][j]중 최소(k는 i에서 j-1까지)
두개를 합칠 땐, 두개를 그 상태까지 만든 비용 + 전체 비용이 듬

for (i=0 ; i<k ; i++)
    d[i][i] = 0; //하나는 비용이 안듬
for (int l=1 ; l<k ; l++) {
    for (i=0 ; i<k-l ; i++) {
        j = i+l;
        int min = Integer.MAX_VALUE;
        for(int m = i ; m<j ; m++) {
            min = Integer.min(min, c[i][j]+d[i][m] + d[m+1][j]);
        }
        d[i][j] = min;
    }
}

Time complexity : O(k*k)
Space complexity : O(k*k)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int k;
	static int[] arr;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int t = Integer.parseInt(input[0]);
		while (--t>=0) {
			k = Integer.parseInt(br.readLine());
			arr = new int[k];
			input = br.readLine().split(" ");
			int i, j;
			for (i=0 ; i<k ; i++)
				arr[i] = Integer.parseInt(input[i]);
			int[][]d = new int[k][k];
			int[][]c = new int[k][k];
			for (i=0 ; i<k ; i++) {
				c[i][i] = arr[i];
				for (j=i+1 ; j<k ; j++) {
					c[i][j] = c[i][j-1]+arr[j];
				}
			}
			for (i=0 ; i<k ; i++)
				d[i][i] = 0;
			for (int l=1 ; l<k ; l++) {
				for (i=0 ; i<k-l ; i++) {
					j = i+l;
					int min = Integer.MAX_VALUE;
					for(int m = i ; m<j ; m++) {
						min = Integer.min(min, c[i][j]+d[i][m] + d[m+1][j]);
					}
					d[i][j] = min;
				}
			}
			System.out.println(d[0][k-1]);
		}
	}
}
