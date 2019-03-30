"
[문제요약]
건물 사이에 길이 X,Y인 사다리가 서로 교차해 x모양으로 있다. 바닥에서 교차점까지의 높이가 c일때,
두 건물 사이의 거리를 구하여라.

[해결방법]
일단 식을 세워보자.
두 건물 사이의 거리를 d라고 할 때,
바닥에서 교차점까지의 높이를 d에 관한 식으로 세울 수가 있다.

이 때, d가 더 높게 나온다면, 건물이 더 가깝다는 얘기이므로 d를 늘린다
반대면 반대

여기선 실수 연산을 하므로, right = mid +1 이런식으로는 못한다.
따라서 right = mid 이렇게 해주는 대신에,
while의 조건문을 while(Math.abs(right-mid) > 0.000001)
이렇게 바꿔 준다.

left의 초기값은 0보다 아주 조금 큰 값,
right의 초기값은 x와 y중에 더 작은 값
으로 시작하면 된다.

Time complexity : O(lg(min(x,y)))
Space complexity : O(1)

[추가]
실수계산은 == 식을 쓰지 못함!
식세우는데 더럽게오래걸림.

이분탐색 : 신경써줘야 할 것이 많다
Yes / no로 나눠지는지?
어떤 경계가 no일때, 그 이상으로는 다 no이다 : 최대값 찾기
어떤 경계가 no일때, 그 이하로는 다 no이다 : 최소값 찾기
검증하는 방법은? <- 이걸 구현하는건 어렵지 않다.
이게 이분탐색으로 풀수 있냐 없냐까지 생각 도달하는게 더 중요한거 같아 보임

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static double x;
	static double y;
	static double c;

	static double test(double d) {
		double h1 = Math.sqrt(x*x-d*d);
		double h2 = Math.sqrt(y*y-d*d);
		return (h1*h2)/(h1+h2);
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		x = Double.valueOf(in[0]);
		y = Double.valueOf(in[1]);
		c = Double.valueOf(in[2]);
		double left = 0.000001;
		double right = Double.min(x, y);
		double mid=0.0;
		while (Math.abs(right-left)>0.000001) {
			mid = (left+right)/2;
			double result = test(mid);
			if (result>c) {
				left = mid;
			} else
				right = mid;
		}
		System.out.println(mid);

	}
}
