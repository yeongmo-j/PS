"
[문제요약]
배열이 들어오고,
이를 오름차순 정렬 했을 때, K번째에 있는 수를 출력하라.

[해결방법]
알고리즘 교재에 있는 랭크 구하는 알고리즘.
일단 퀵솔트에 있는 알고리즘과 비슷한(같은) pivot 메소드를 통해
pivot의 전에는 같거나 작은 수들만, 후에는 큰 수들만 위치하게 만든 뒤에,
그 pivot의 인덱스를 반환하여, pivot이 몇번째 수인지를 계산한다.

그 뒤에, 목표로 하는 k와 비교하여, 같으면 그 인덱스에 해당하는 수 출력,
더 앞에있으면 그 앞으로 재귀, 더 뒤에있으면 그 뒤로 재귀 하면 된다.

Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
Time complexity가 이게 맞나?? 교재 확인
"
import java.util.Scanner;

public class Main {

	static void change(int[]arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static int pivot(int[] arr, int p, int q) {
		int r = (int)(p+Math.random()*(q-p));
		change(arr, p, r);
		int k = arr[p];
		int i= p;
		int j ;
		for (j=p+1 ; j<=q ; j++) {
			if (arr[j]<=k) {
				i++;
				change(arr, i, j);
			}
		}
		change(arr, p, i);
		return i;
	}

	static int kth(int[] arr, int p, int q, int k) {
		if (p>=q)
			return arr[p];
		int r = pivot(arr, p, q);
		int rankR = r-p+1;
		if (rankR==k)
			return arr[r];
		if (rankR>k)
			return kth(arr, p, r-1, k);
		return kth(arr, r+1, q, k-rankR);
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int K = scin.nextInt();
		int[] arr = new int[N];
		for (int i=0 ; i<N ; i++)
			arr[i] = scin.nextInt();

		System.out.println(kth(arr, 0, N-1, K));

		scin.close();
	}
}
