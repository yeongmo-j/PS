"
[문제요약]
순열이 주어지면, 사전순으로 그 다음 순열 뭔지 출력하기

[해결방법]
다음 순열 구하는 법
1. a[i-1]<a[i]인 마지막 i를 찾는다.
2. i<=j인 j 중에 a[i-1]<a[j]인 마지막 j를 찾는다
3. i-1과 j를 바꿔준다
4. i부터 뒤로 있는 부분수열을 뒤집어준다


왜그런지는 아직 잘 모르겠음
수열의 사전순 첫번째 : 1 2 3 4 5
마지막 : 5 4 3 2 1

Time complexity : O(N)
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


10973 이전수열문제는 부등호만 반대로 바꿔주면 된다.


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main{

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

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.valueOf(in[0]);
		int[] arr = new int[n];
		in = br.readLine().split((" "));
		int i=0, j=0, k;
		for (k=0 ; k<n ;k++)
			arr[k] = Integer.parseInt(in[k]);
		for (k=1 ; k<n ; k++) {
			if (arr[k-1]<arr[k])
				i = k;
		}
		if( i==0) {
			System.out.println(-1);
		} else {
			for (k=i ; k<n ; k++) {
				if (arr[i-1]<arr[k])
					j = k;
			}
			swap(arr, i-1, j);
			reverse(arr, i, n-1);
			StringBuilder stb = new StringBuilder();
			for (int c : arr) {
				stb.append(c+" ");
			}
			System.out.println(stb);
		}
	}
}
