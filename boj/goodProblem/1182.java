"
[문제요약]
n개의 수열이 들어오고 (원소가 n개인 수열)
이 부분수열의 합이 s인 개수를 구하여라(공집합은 미포함 )

[해결방법]
재귀함수를 만들어준다 run(int sum, int k, int len)
의미는 지금 k번째 원소를 살펴보는 중이며, 지금까지 합은 sum이다. len은 지금까지 선택한 원소의 개수
이상태로 종료조건까지 가서, 그때 sum을 확인해준다.
sum먼저 확인해주면 중복됨
종료조건 : k>=n

Time complexity : O(2^n)
Space complexity : O(n)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static int[] arr;
	static int s;
	static int count;

	static void run(int sum, int k, int len) {
		//지금까지 모은 점수가 sum이고, k번째를 탐색중, 지금까지 모은 원소의 수는 len
		if (k>=n) {
			if (sum==s && len>0)
				count++;
			return;
		}
		run(sum+arr[k], k+1, len+1);
		run(sum, k+1, len);

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		count=0;
		arr = new int[n];
		input = br.readLine().split(" ");
		int i;
		for (i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(input[i]);
		run(0, 0, 0);
		System.out.println(count);
	}
}
