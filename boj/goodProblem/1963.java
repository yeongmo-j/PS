"
[문제요약]
4자리 소수 2개가 주어지고
첫번째 소수에서 한가지 자리수를 골라 그 수를 바꿔서 다른 소수로 바꾸는 단계를 1단계라 할 떄
몇단계를 거쳐야 두번째 소수로 갈 수 있니?
1033 1733 3733 3739 3779 8779 8179 처럼


[해결방법]
일단 아리토네스의 체로 10000 이하의 소수들을 다 판별 해 놓는다

그리고 숫자를 입력하면
한자리 바꿔서 갈 수 있는 모든 수의 리스트를 출력해주는 메소드를 하나 만든다(약 40개의 수를 리턴)

그래서 큐로 BFS를 사용한다
연결 정보는 저 위에서 만들어준 메소드임.

또 BFS를 위한 visited와 몇번만에 갔는지 count해주는 배열도 선언해준다

그다음 BFS

Time complexity : O(1) 최대 만번
Space complexity : O(1)

[추가]

"


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{


	static LinkedList<Integer> one(int n){
		char[] characterNum;
		LinkedList<Integer> result = new LinkedList<>();
		int i, j;
		for (i=0 ; i<4 ; i++) {
			characterNum = (n+"").toCharArray();
			for (j=0 ; j<10 ; j++) {
				if (!(i==0&&j==0)) {
					characterNum[i]=(char)(j+'0');
					result.add(Integer.valueOf(new String(characterNum)));
				}
			}
		}
		return result;
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] notPrime = new boolean[10000]; //true면 소수가 아닌거
		int i, j;
		for (i=2 ; i<10000 ; i++) {
			if (notPrime[i]==false)
				for (j=2 ; i*j<10000 ; j++)
					notPrime[i*j] = true;
		}
		int T = Integer.valueOf(br.readLine());
		while (--T>=0) {

			String[] input = br.readLine().split(" ");
			Queue<Integer> queue = new LinkedList<Integer>();

			boolean[] visited = new boolean[10000];
			int[] count = new int[10000];

			queue.add(Integer.valueOf(input[0]));
			visited[Integer.valueOf(input[0])] = true;
			while (!queue.isEmpty()) {
				int now = queue.remove();
				LinkedList<Integer> list = one(now);
				for (int n : list) {
					if (!visited[n] && !notPrime[n]) {
						visited[n] = true;
						count[n] = count[now]+1;
						queue.add(n);
					}
				}
			}

			System.out.println(count[Integer.valueOf(input[1])]);

		}
	}
}
