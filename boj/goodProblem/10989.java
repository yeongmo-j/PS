"
[문제요약]
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
이 때, 들어오는 숫자의 범위는 10000 이하의 자연수이다.

[해결방법]
범위가 정해져있다 -> radix sort를 고려 해보자.
그러나 이 문제는!! 굳이 정렬할 필요가 없다.
그냥 arr[i] 는 i가 입력된 횟수
로 저장해서 1씩 늘린다음에
1부터 10000까지 돌리며 들어온 수만큼 출력 해주면 된다.

Time complexity : O(N)
Space complexity : O(N)

[추가]
그러나 이렇게 문제를 풀면 시간초과가 난다.
그래서 Scanner가 아닌 BufferedReader 로 하면 된다고 하는데
추후에 이부분 공부 후 다시 풀어볼 것.
"
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();
		int[] arr = new int[10001];
		int temp;
		while (--N>=0) {
			temp = scin.nextInt();
			arr[temp]++;
		}
		for (int i=1 ; i<=10000 ; i++) {
			for (int j=0 ; j<arr[i] ; j++) {
				System.out.println(i);
			}
		}
		scin.close();
	}
}
