"
[문제요약]
0~9까지 수 4자리를 저장하는 레지스터가 있다. 즉 이는 0부터 9999까지 저장을 할 수가 있는데
이는

D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

다음과 같은 4개의 연산을 할 수가 있다.
숫자 2개가 주어지고

첫번째 숫자에서 연산 n번을 통해 두번째 숫자로 바꾸고자 할 때, 그 최소 회수의 연산 방법을 출력



[해결방법]
BFS를 이용한다
연결경로는 저 4개의 연산

방문 정보인 visited와
그 전에 있던 숫자의 정보인 from[]
또, 어떤 연산을 썼는지의 how[] 를 저장해준다.

결국 도착 한 뒤에,
from을 따라 계속 되돌아 가면서 how[]에 쓰인 정보들을 같이 출력해주면 된다


Time complexity : O(1) 최대 만번
Space complexity : O(1)

[추가]

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



class Info{
	int num;
	char control;
	Info(int num, char control){
		this.num = num;
		this.control = control;
	}
}

public class Main{


	static LinkedList<Info> one(int n){
		LinkedList<Info> result = new LinkedList<>();
		result.add( new Info((2*n)%10000,'D'));
		int temp = n==0? 9999 : n-1;
		result.add(new Info(temp,'S'));
		temp = (n%1000)*10+n/1000;
		result.add(new Info(temp,'L'));
		temp = n/10 + (n%10)*1000;
		result.add(new Info(temp,'R'));
		return result;
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int T = Integer.valueOf(br.readLine());
		while (--T>=0) {

			String[] input = br.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<Integer>();

			boolean[] visited = new boolean[10000];
			int[] from = new int[10000];
			char[] how = new char[10000];

			int start = Integer.valueOf(input[0]);
			queue.add(start);
			visited[start] = true;
			while (!queue.isEmpty()) {
				int now = queue.remove();
				LinkedList<Info> list = one(now);
				for (Info n : list) {
					if (!visited[n.num]) {
						visited[n.num] = true;
						from[n.num] = now;
						how[n.num] = n.control;
						queue.add(n.num);
					}
				}
			}

			int end = Integer.valueOf(input[1]);
			LinkedList<Character> result = new LinkedList<>();
			while (end != start) {
				result.add(how[end]);
				end = from[end];
			}
			Collections.reverse(result);
			for (char c : result) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
