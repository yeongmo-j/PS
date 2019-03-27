"
[문제요약]
N*N배열이 들어오는데 1,0,-1중 하나다
만약 그 숫자가 다 1로 이루어져있으면 1을 하나 세준다
만약 다르다면,3*3개로 나눠서 똑같은거 반복해서
결국에 1로 이뤄진거 0으로 이뤄진거 -1로 이뤄진거 찾기

[해결방법]
divide

Time complexity : O(NlgN) : T(N) = 9T(N/9) + O(N)
Space complexity : O(log_9^N) :시스템 스택

[추가]
BufferedReader 사용법 조심(처음에 정수 받을 때)

"


package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	static int[] result;
	static int[][] arr;

	static boolean same(int i1, int j1, int n){
		int origin = arr[i1][j1];
		for (int i=0 ; i<n ; i++){
			for (int j=0 ; j<n ; j++){
				if (arr[i1+i][j1+j]!=origin)
					return false;
			}
		}
		return true;
	}

	static void cut(int i1, int j1, int n) {
		if (same(i1,j1,n)){
			result[arr[i1][j1]+1]++;
			return;
		}
		int len = n/3;
		for (int i=0 ;i<3 ; i++) {
			for (int j = 0; j < 3; j++) {
				cut(i1 + i * len, j1 + j * len, len);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		arr = new int[N][N];
		result = new int[3];
		int i, j;
		for (i=0 ; i<N ; i++) {
			String[] list = br.readLine().split(" ");
			for (j=0 ; j<N ; j++) {
				arr[i][j] = Integer.parseInt(list[j]);
			}
		}
		cut(0,0,N);
		for (int c : result) {
			System.out.println(c);
		}
	}
}
