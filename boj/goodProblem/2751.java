"
[문제요약]
수 정렬하기

[해결방법]
퀵솔트 이용했음.
그런데 시간 초과가 나왔다.
-> 최악의 경우가 테스트 케이스에 있을 수 있다는 것을 간과.
랜덤으로 피벗 고르는 것을 넣어주었다.

Time complexity : O(NlgN)
Space complexity : O(1);

[추가]
구간 사이에서 랜덤 구하는 법
(난수 범위의 최솟값) + (난수 범위의 길이)×Math.random()
"

import java.util.Scanner;

class Quick{
	static int randNum(int p, int q) {
		return (int)(p+(q-p)*Math.random());
	}
	static int partition(int[]arr , int p, int q) {
		int temp;
		int rand = randNum(p,q);
		temp = arr[p];
		arr[p]=arr[rand];
		arr[rand]=temp;
		int x = arr[p];
		int i=p;
		int j;
		for (j=p+1 ; j<=q ; j++) {
			if (arr[j]<=x) {
				i++;
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		temp = arr[p];
		arr[p]=arr[i];
		arr[i]=temp;
		return i;
	}
	static void sort(int[]arr, int p, int q) {
		if (p>=q)
			return;
		int r = partition(arr,p,q);
		sort(arr,p,r-1);
		sort(arr,r+1,q);
	}
}

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		int[] arr = new int[N];
		int i;
		for (i=0 ; i<N ; i++)
			arr[i] = scin.nextInt();
		Quick.sort(arr, 0, N-1);
		for (int x : arr) {
			System.out.println(x);
		}
		scin.close();
	}
}
