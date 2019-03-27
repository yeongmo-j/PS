"
[문제요약]
다 같음숫자면 그 숫자로 카운트해주고
아니면, 4등분해서 반복하기

[해결방법]
재귀

Time complexity : O(NlgN) T(N) = 4T(N/4)+O(N)
Space complexity : O(log_4^N) 스택의 높이

[추가]

"

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	static int[][] pict;
	static StringBuilder str;




	static void quadTree(int i, int j, int N) {
		if (N==1) {
			str.append(pict[i][j]);
			return;
		}
		int origin = pict[i][j];
		int itemp, jtemp, k, l;
		for (itemp=i ; itemp<i+N ; itemp++) {
			for (jtemp=j ; jtemp<j+N ; jtemp++) {
				if (pict[itemp][jtemp]!=origin) {
					int length = N/2;
					k=i;
					str.append('(');
					while (k<i+N) {
						l = j;
						while (l<j+N) {
							quadTree(k,l,length);
							l+=length;
						}
						k+=length;
					}
					str.append(')');
					return;
				}
			}
		}
		str.append(origin);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		str = new StringBuilder();
		pict = new int[N][N];
		int i, j;
		for (i=0 ; i<N ; i++) {
			String temp = br.readLine();
			for (j=0 ; j<N ; j++) {
				pict[i][j] = (int)(temp.charAt(j)-'0');
			}
		}
		str.append('(');
		quadTree(0,0,N);
		str.append(')');
		System.out.println(str);
	}
}
