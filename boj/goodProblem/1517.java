"
[문제요약]
버블소트 진행 할 때, swap을 몇번 하는지 리턴.
실제로 버블소트를 구현하면, 시간초과 나오게 되어 있음.

[해결방법]
swap의 개수를 구하는 거는
i<j일 떄, A[i] > A[j]인 개수를 구하는 것과 같다.
하지만, 이를 다 하나하나 구하려면 역시 O(N^2)이 나와서 시간초과이다.
i<j일 때 A[i]>A[j]인걸 신경 쓰는것 : 머지소트와 비슷
머지소트를 살펴보자.
3 5 2 9가 있을 때,
3 5 / 2 9 로 나눠서 재정렬을 하는데,
이때 앞에놓인 2개가 먼저 뽑힌다는 뜻은, i<j일 때, A[i] <= A[j] 라는 뜻이 된다.
그래서, 앞의 뭉치들이 뽑힐때는 문제가 없다.
이제, 뒤의 뭉치들이 뽑히는 경우는, 앞의 뭉치중에 아직 안뽑힌 개수보다 i<j일 때 A[i]> A[j]라는 뜻으로,
그 개수 만큼 swap이 일어나게 된다.
이를 count 해주면 된다.

Time complexity : O(NlgN) 머지 소트
Space complexity : O(N)

[추가]
count해줄 때, 최대 N(N+1)/2가 될 수 있으므로, (역숙으로 정렬되어 있을 때,)
int로 선언을 해주면 안된다. long으로 선언을 해줘야 한다.

또, 머지 솔트 해줄 때에,
while (i <= mid || j <= end) {
    if (i <= mid && (j > end || a[i] <= a[j])) {
        b[k++] = a[i++];
    } else {
        ans += (long long)(mid-i+1);
        b[k++] = a[j++];
    }
}

@@@@@@@
이렇게 해서, 남은 뭉치들 다 추가해주는 루프 2번을 안하고 루프 한번으로 대체 해줄 수도 있다.


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main{
	static int[] arr;
	static long count=0;

	static void mergeSort(int p, int q) {
		if (p>=q)
			return;
		int r = (p+q)/2;
		mergeSort(p, r);
		mergeSort(r+1, q);
		merge(p, q);
	}

	static void merge(int p, int q) {
		int r = (p+q)/2;
		int len = q-p+1;
		int[] temp = new int[len];
		int idx=0, i=p, j=r+1;
		while (i<=r && j<=q) {
			if (arr[i] <= arr[j]) {
				temp[idx] = arr[i];
				i++;
			} else {
				temp[idx] = arr[j];
				j++;
				count += r-i+1;
			}
			idx++;
		}
		while (i<=r) {
			temp[idx] = arr[i];
			i++;
			idx++;
		}
		while (j<=q) {
			temp[idx] = arr[j];
			j++;
			idx++;
		}
		for (i=0 ; i<len ; i++)
			arr[p+i] = temp[i];
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		arr = new int[N];
		int i;
		for (i=0 ; i<N ; i++)
			arr[i] = Integer.parseInt(str[i]);
		mergeSort(0, N-1);
		System.out.println(count);
	}
}
