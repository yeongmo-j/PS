"
[문제요약]
숫자가 들어오면,
1~n까지의 모든 순열 출력

[해결방법]
다음 순열 구하는 법
1. a[i-1]<a[i]인 마지막 i를 찾는다.
2. i<=j인 j 중에 a[i-1]<a[j]인 마지막 j를 찾는다
3. i-1과 j를 바꿔준다
4. i부터 뒤로 있는 부분수열을 뒤집어준다
이게 가능하면 ,true, 아니면 false를 리턴 해주고
true인동안 계속 출력

Time complexity : O(N*N!) (한번에 N만큼 걸리는데 전체 N!번)
Space complexity : O(N)

[추가]
@@@@@@@@@@@뒤집을때 이렇게 뒤집어 주면 된다@@@@@@@@@
j = a.length-1;
while (i < j) {
    temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    i += 1;
    j -= 1;
}

또, nextPerm을 먼저 시작하면, 순열을 한번 바꾸고 시작하기 떄문에
첫번째 순열이 나오질 않는다.
고로, 첫번째 순열은 한번ㄴ 출력 해준 다음에 시작해야 함.
"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] arr;
	static int n;

	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	static void reverse(int[]arr, int start, int end) {
		int len = end-start+1;
		int half = len/2;
		for (int i=0 ; i<half ; i++) {
			swap(arr, start+i, end-i);
		}
	}
	static void print() {
		StringBuilder stb = new StringBuilder();
		for (int c : arr) {
			stb.append(c+" ");
		}
		System.out.println(stb);
	}

	static boolean nextPerm() {
		int i=0, j=0, k;
		for (k=1 ; k<n ; k++) {
			if (arr[k-1]<arr[k])
				i = k;
		}
		if( i==0) {
			return false;
		} else {
			for (k=i ; k<n ; k++) {
				if (arr[i-1]<arr[k])
					j = k;
			}
			swap(arr, i-1, j);
			reverse(arr, i, n-1);
			print();
			return true;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		n = Integer.valueOf(in[0]);
		arr = new int[n];
		int k;
		for (k=0 ; k<n ;k++)
			arr[k] = k+1;
		print();
		while (nextPerm());
	}
}
