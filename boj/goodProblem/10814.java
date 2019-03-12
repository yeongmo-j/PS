"
[문제요약]
회원 이름, 나이가 주어지는데
나이순으로 정렬, 만약 나이 같으면 먼저들어온사람이 앞으로 오게

[해결방법]
먼저들어온사람이 앞으로 오게 하려면
stable sorting이 필요한데, merge sort가 그 예이다.
그래서 Merge sort를 구현 해 줬음.


Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
merge sort 맞게 했는지 확인.
"
import java.util.Scanner;

class Member {
	int age;
	String name;
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
}

public class Main {

	static void mergeSort(Member[] arr, int p, int q) {
		if (p>=q)
			return;
		int r = (p+q)/2;
		mergeSort(arr, p, r);
		mergeSort(arr, r+1, q);
		merging(arr, p, r, q);
	}

	static void merging(Member[] arr, int p, int r, int q) {
		int firstNum = (r-p)+1;
		int secondNum = (q-(r+1))+1;
		Member[] first = new Member[firstNum+1];
		Member[] second = new Member[secondNum+1];
		int i;
		for (i=0 ; i<firstNum ; i++) {
			first[i] = arr[p+i];
		}
		first[firstNum] = new Member(Integer.MAX_VALUE, "");
		for (i=0 ; i<secondNum ; i++) {
			second[i] = arr[r+1+i];
		}
		second[secondNum] = new Member(Integer.MAX_VALUE, "");
		int idx = p;
		int firstIdx = 0;
		int secondIdx = 0;
		for (i=0 ; i<firstNum+secondNum ; i++) {
			int compare = first[firstIdx].age-second[secondIdx].age;
			if (compare<=0) {
				arr[idx++] = first[firstIdx++];
			}
			else {
				arr[idx++] = second[secondIdx++];
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();
		Member[] arr = new Member[N];
		int i;
		for (i=0 ; i<N ; i++) {
			int age = scin.nextInt();
			String name = scin.next();
			arr[i] = new Member(age, name);
		}
		mergeSort(arr, 0, N-1);
		for (Member m : arr) {
			System.out.printf("%d %s\n", m.age, m.name);
		}

		scin.close();
	}
}
