"
[문제요약]
문자열이 들어올 때,
문자열을 부분 팰린드롬 여러개로 쪼갤 수가 있다.
들어, ABACABA를 팰린드롬으로 분할하면, {A, B, A, C, A, B, A}, {A, BACAB, A}, {ABA, C, ABA}, {ABACABA}
로 쪼갤 수 있을 때,
그 부분 팰린드롬의 개수가 최소인 걸 구해라
여기선 {ABACABA}가 1로 최소임
즉, 최대값은 문자열의 길이, 최소값은 1인데 이중 정답을 찾으란 얘기임

[해결방법]
DP 이용 (10942번)
d[i][j]는 i,j까지 이동할 수 있는 경우의 수
if (d[i][j]!=0 && !(i==N-1 && j==N-1)) {
    int go = cango[i][j];
    if (i+go<N)
        d[i+go][j]+=d[i][j];
    if (j+go<N)
        d[i][j+go]+=d[i][j];
}
로 일단 i에서 j까지가 팰린드롬인지를 판별 해 놓는다

이제 새로운 dp 사용
dd[i]는 0~i번째까지의 최소 부분팰린드롬 개수
이제 문재를 쪼개본다.
0~j-1 / j~i  이렇게 쪼개보면
j~i까지가 팰린드롬일 때 = d[j][j] = true 일 때
dd[i] = d[j-1]+1 중에 최소인 값 @@@@@@@@
을 찾으면 된다(j값을 바꿔가며)

int[] dd = new int[n];
dd[0] = 1;
for (i=1 ; i<n ; i++) {
    int min = n;
    for (j=i ; j>=0 ; j--) {
        if (d[j][i]) {
            if (j==0)
                min = 1;
            else
                min = Integer.min(min, dd[j-1]+1);
        }
    }
    dd[i] = min;
}

즉 이렇게 바뀜.

답 = dd[n-1]

Time complexity : O(N^2)
Space complexity : O(N^2)

[추가]


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static boolean[][] d;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		char[] arr = input[0].toCharArray();
		int n = arr.length; //lastIndex = n-1;
		d = new boolean[n][n];
		//d[i][j] means i부터 j까지의 palindrome이면 true, 아니면 false
		int i, j;
		for (i=0 ; i<n ; i++)
			d[i][i] = true;
		for (i=0 ; i<n-1 ; i++)
			d[i][i+1] = arr[i]==arr[i+1] ? true : false;
		for (int l=2 ; l<=n-1 ; l++) {
			for (i=0 ; i<n-l ; i++) {
				j = i+l;
				if (d[i+1][j-1]==true && arr[i]==arr[j])
					d[i][j] = true;
				else
					d[i][j] = false;
			}
		}
		int[] dd = new int[n];
		dd[0] = 1;
		for (i=1 ; i<n ; i++) {
			int min = n;
			for (j=i ; j>=0 ; j--) {
				if (d[j][i]) {
					if (j==0)
						min = 1;
					else
						min = Integer.min(min, dd[j-1]+1);
				}
			}
			dd[i] = min;
		}

		System.out.println(dd[n-1]);
	}
}
