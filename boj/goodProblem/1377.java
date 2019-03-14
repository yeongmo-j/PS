"
[문제요약]
배열이 들어오고,
이를 오름차순 정렬 했을 때, K번째에 있는 수를 출력하라.

[해결방법]
버블솔트 큰수를 뒤로 옮기는 알고리즘에서,
앞에서 (맨)뒤로 옮기는건 루프 한번에 가능함.
그러나 뒤에있는수를 앞으로 옮기는건 루프 한번에 한칸밖에 불가능함.

-> 뒤에있는 수가 앞으로 오려면 몇칸 앞으로 와야하는지?

그래서 원래 배열이
10 1 5 2 3 이면
정렬하면
1 2 3 5 10 이 된다.
여기서 앞으로 와야하는 단계만 계산하면 된다.
원래 배열의 앞에서부터 살펴보면,
10은 뒤로 가야된다->한번에 가능
1은 앞으로 한칸 와야한다
5는 뒤로 가야된다->한번에 가능
2는 앞으로 두칸 와야한다
3은 앞으로 두칸 와야한다.


즉, 루프를 두번 돌려서 2,3을 두칸 앞으로 이동시켜야 하고,
정답은 다 완료된 후에 그 다음 인덱스를 출력 하는 것이므로,(아무 이동이 없을 때의 인덱스)
거기에 1을 더해서 출력해주면 된다.

@@여기서 몇칸 앞에왔는지 확인하기 위해선,
두개의 정보를 저장하면 된다.
Class information {
  int value;
  int originIdx;
}
이렇게 처음 인덱스를 저장해준 다음에,
정렬 시키고 나서, 그 인덱스와 저 originIdx의 차이를 계산해주면 된다!


Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
내가 푼게 아니라 그냥 강의 보고 익힌거임. 복습 필수 (기초-정렬 응용 마지막)

"
import java.util.Arrays;
import java.util.Scanner;

class Information implements Comparable<Information> {
	int value;
	int idx;
	Information(int value, int idx){
		this.value = value;
		this.idx = idx;
	}

	public int compareTo(Information another) {
		if (this.value > another.value)
			return 1;
		else if (this.value < another.value)
			return -1;
		return 0;
	}
}

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		int N = scin.nextInt();
		Information[] arr = new Information[N];
		int i;
		for (i=0 ; i<N ; i++) {
			arr[i] = new Information(scin.nextInt(), i);
		}
		Arrays.sort(arr);

		int maxDif = 0;
		for (i=0 ; i<N ; i++) {
			if (i<arr[i].idx) {
				int dif = arr[i].idx - i;
				if (dif>maxDif)
					maxDif = dif;
			}
		}
		System.out.println(maxDif+1);
		//정렬이 다 완료된 그 다음루프에 출력되기 때문에, +1

		scin.close();
	}
}
