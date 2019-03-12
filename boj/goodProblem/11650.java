"
[문제요약]
x좌표 y좌표 정렬

[해결방법]
Coordinate class 만들어 주고,
Comparable<Coordinate> 인터페이스를 구현 해준다

그러면 public int compareTo(Coordinate x)
메소드를 구현 해주면 된다.
본인이 더 크면 1 같으면 0 아니면 -1을 리턴 해주면 됨.

Time complexity : O(NlgN)
Space complexity : O(N)

[추가]
implements Comparable<T>
@Override
public int compareTo(T another)
잘 기억해 둘 것!

또 Arrays.sort는 java.util.Arrays에 들어 있다.
"
import java.util.Arrays;
import java.util.Scanner;

class Coordinate implements Comparable<Coordinate>{
	int x;
	int y;
	Coordinate(int x, int y){
		this.x = x;
		this.y= y;
	}
	private int compare(int one, int two) {
		if (one>two)
			return 1;
		else if (one==two)
			return 0;
		return -1;
	}

	@Override
	public int compareTo(Coordinate another) {
		int result = compare(this.x, another.x);
		if (result==0) {
			return compare(this.y, another.y);
		}
		return result;
	}
}

public class Main {

	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int N = scin.nextInt();

		Coordinate[] arr = new Coordinate[N];
		int i, x, y;
		for (i=0 ; i<N ; i++) {
			x = scin.nextInt();
			y = scin.nextInt();
			arr[i] = new Coordinate(x,y);
		}
		Arrays.sort(arr);
		for (Coordinate c : arr) {
			System.out.printf("%d %d\n", c.x, c.y);
		}
		scin.close();
	}
}
