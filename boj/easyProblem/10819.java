"
[문제요약]
n개의 원소를 가진 배열이 들어오고,(3<=n<=8)
원소를 재배열 할 수 있을 때, 각 원소의 차이의 절대값이 최대인 값을 구하여라
|a[0]-a[1]| + |a[1]-a[2]| +.... 이게 최대여야 함

[해결방법]
일단 n이 10이 넘으면 숫자가 너무 커짐으로, n!의 모든 경우의 수를 탐색 불가능하다
그런데 숫자가 작으므로 전체 탐색 가능.

모든 경우의수 조합해본다음에, 계산

Time complexity : O(n!*n) n!개수에 계산하는데 n
Space complexity : O(n)

[추가]
이렇게 범위가 좁을 경우엔 다 해보자
"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static int[] arr;
	static int max;

	static int calculate() {
		int sum=0;
		for (int i=0 ; i<=n-2 ; i++)
			sum+=Math.abs(arr[i]-arr[i+1]);
		return sum;
	}

	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void run(int startIdx) {
		if (startIdx==n-1) {
			max = Math.max(max, calculate());
		} else {
			for (int i=startIdx ; i<n ; i++) {
				swap(startIdx, i);
				run(startIdx+1);
				swap(startIdx, i);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		String[] str = br.readLine().split(" ");
		arr = new int[n];
		max = Integer.MIN_VALUE;
		int i;
		for (i=0 ; i<n ; i++)
			arr[i] = Integer.valueOf(str[i]);
		run(0);
		System.out.println(max);

	}
}
