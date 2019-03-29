"
[문제요약]
배열 중에서, 연속된 원소들을 몇개 고를 때, 그 연속된 부분배열의 원소의 합 중 제일 큰 값 찾기.


[해결방법]
dp bottom up으로 풀었다.
연속된 원소를 구하는 거니까, A[i]번쨰 원소를 살펴볼 때, 이 원소를 선택할때는 두가지 방법밖에 없다.
바로 앞에서 구한 합에다가 이 원소를 더하던가, 아니면 이 원소로 다시 시작 하던가.
그러므로 d[i]를 A[i]번째 원소를 선택 할 때, 앞에서부터 여기까지 연속된 부분배열 중 최대 합이라고
정의하면 , d[i] = max{d[i-1]+A[i], A[i]}가 된다.

Time complexity : O(N)
Space complexity : O(N);

[추가]
max 구할 때 , max=0 부터 시작하는게 아니라,
max = Integer.MIN_VALUE 로 해야 함!!! (음수가 인풋으로 들어옴 )
혹은 max = d[0] 으로 지정해줘도 된다!!
"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int n = scin.nextInt();
		int[] A = new int[n+1];
		int i, j;
		for (i=1 ; i<=n ; i++)
			A[i] = scin.nextInt();
		int[] d = new int[n+1];
		//d[i]는 A[i]가 마지막으로 포함된 연속된 부분 수열 중에서, 가장 그 합이 큰 값
		//즉 A[i]가 처음이거나,i-1까지 구한 값+A[i] 둘중의 하나이다.
		for (i=1 ; i<=n ; i++) {
			d[i] = Math.max(d[i-1]+A[i], A[i]);
		}

		int max = Integer.MIN_VALUE;
		for (i=1 ; i<=n ; i++){
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
		scin.close();
	}
}
