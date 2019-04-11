"
[문제요약]
n개중에 6개 고르는 방법의 수를 사전순으로 출력

[해결방법]
일단 next_perm() 메소드를 생각해보자
111110000000 과 같은 순열의 다음 순열을 구할 때
next_perm이 작동할까?
작동한다!
그러나 가지수는 n!/1의개수!*0의개수! 가 된다

이제 문제에 적용해보면
111111 0000000000000 으로 시작하는 순열을
이전순열로 한단계씩 바꿔가면서 000000000000 111111이 될때까지 순열을 계산해준다
그다음에 입력으로 받은 n개와 저 1,0들을 일대일 매핑시켜줘서
1이면 선택, 0이면 선택 안해주는걸로 해준다!!!!

Time complexity : O(n!/(6!(n-6)!) * n ) 출력하는데 n만큼 또 걸리므로
Space complexity : O(n)

[추가]
nCm구하는법!!!!!!!!!

그리고 재귀함수로 구하는 법도 있음
run(String str, int f, int n)
의미는 지금까지 f개 골랐고, arr[n]을 살펴보고 있는 중임.
성공조건 : f==6
종료조건 : n>=k
나머지는 고르던가, 안고르던가 해주면 됨!!!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int k;
	static int[] s;

	static void run(String str, int f, int n) {
		//지금까지 f개 골랐고, s[n]번째 인덱스 살펴보는중 str은 지금까지 고른걸 스트링으로
		if (f==6) {
			System.out.println(str);
			return;
		} else if (n>=k)
			return;
		run(str+s[n]+" ", f+1, n+1);
		run(str, f, n+1);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] input = br.readLine().split(" ");
			k = Integer.parseInt(input[0]);
			if (k==0)
				break;
			s = new int[k];
			int i;
			for (i=0; i<k ; i++)
				s[i] = Integer.parseInt(input[i+1]);
			run("", 0, 0);
			System.out.println();
		}
	}
}

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int n;
	static int[] arr;
	static int[] perm;

	static void swap(int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}

	static boolean permNext() {
		int i=-1, j=0, k;
		for (k=1 ; k<n ; k++) {
			if (perm[k-1]>perm[k])
				i = k;
		}
		if (i==-1)
			return false;
		for (k=i ; k<n ; k++) {
			if (perm[i-1] > perm[k])
				j = k;
		}
		swap(i-1, j);
		int left = i, right = n-1;
		while (left<right) {
			swap(left,right);
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int i;
		while (true) {
			String[] str = br.readLine().split(" ");
			n = Integer.valueOf(str[0]);
			if (n==0)
				break;
			arr = new int[n];
			perm = new int[n];
			for (i=1 ; i<=n ; i++)
				arr[i-1] = Integer.valueOf(str[i]);
			Arrays.sort(arr);
			for (i=0 ; i<6 ; i++)
				perm[i] = 1;
			do {
				for (i=0 ; i<n ; i++) {
					if (perm[i] == 1)
						stb.append(arr[i]+" ");
				}
				stb.append("\n");
			} while (permNext());
			stb.append("\n");
		}
		System.out.print(stb);
	}
}
