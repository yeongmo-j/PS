"
[문제요약]
8퍼즐이 있다
1 2 3
4 5 6
7 8
의 형태로 만드는게 목표임
저 9가 들어갈 빈칸은 비어있고,
그 빈 칸으로 주위의 퍼즐을 밀어서 옮길 수 이씅ㅁ

예를들면
1   3
4 2 5
7 8 6
를 저 위에 12345678로 정렬되게 만드는게 목표임
최소회수를 구하여라

[해결방법]
BFS로 시뮬레이션을 해준다.
여기서 저 퍼즐의 정보를 2차원 배열이 아닌, 1차원 배열로 저장해줘도 된다!
int[10]짜리를 선언 한 뒤에 인덱스 1~9까지를 사용하면 됨!!
그리고 빈칸은 9로 사용하면 됨!

각 인덱스에 해당하는 값이 9일 경우, 이동 가능한 칸들이 다르므로, 이를 잘 생각해줘서 연결정보로 생각해주면 된다.

즉, 배열을 넣으면 거기서 9를 찾고, 9로 이동시킬 수 있는 경우의 수를 찾아 그 경우의 수(배열)의
링크드리스트를 리턴해주는 메소드를 하나 만들어, 이를 연결 정보로 삼는다.

또 이전에 방문했떤 정보인 visited배열 대신에

@@@@@Map@@@@@ 으로 대체한다!!!!!
10짜리 배열을 string으로 바꿔주어서, 이를 키로 해주면 지금까지 방문 했었는지 쉽게 저장할 수 있다!!
만약 방문 안했떤거면, 방금 전꺼 +1로 저장해주면 회수도 저장이 된다!!!!

Time complexity : O(9! = 1)
Space complexity : O(9! = 1)

[추가]
1. 방문 정보 map으로 저장하기
2. 2차원 퍼즐을 1차원 배열로 저장 할 수 있다
좋은 생각
"

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	static String toString(int[] arr) {
		StringBuilder str = new StringBuilder();
		for (int i=1 ; i<=9 ; i++) {
			str.append(arr[i]);
		}
		return str.toString();
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static LinkedList<int[]> nextMove(int[] now){
		LinkedList<int[]> result = new LinkedList<>();
		int i, nine=0;
		for (i=1 ; i<=9 ; i++) {
			if (now[i]==9)
				break;
		}
		//위로 올릴 수 있는 경우, 1~6에 있을 때
		int[] temp = now.clone();
		if (i>=1 && i<=6) {
			swap(temp, i, i+3);
			result.add(temp.clone());
			swap(temp, i, i+3);
		}
		//왼쪽으로 : 1,4,7,2,5,8일 경우
		if (i%3!=0) {
			swap(temp,i,i+1);
			result.add(temp.clone());
			swap(temp,i,i+1);
		}
		//오른쪽으로 : 1,4,7 아니면 됨
		if (i%3!=1) {
			swap(temp, i, i-1);
			result.add(temp.clone());
			swap(temp,i,i-1);
		}
		//아래로 갈 수 있는 경우 : 4~9사이
		if (i>=4 && i<=9) {
			swap(temp,i,i-3);
			result.add(temp.clone());
			swap(temp,i,i-3);
		}
		return result;
	}


	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scin = new Scanner(System.in);
		int[] arr = new int[10]; //1~9까지를 사용
		int i;
		for (i=1 ; i<=9 ; i++) {
			int temp = scin.nextInt();
			if (temp==0)
				temp = 9;
			arr[i] = temp;
		}
		Map<String,Integer> map = new HashMap<String,Integer>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(arr.clone());
		map.put(toString(arr), 0);
		while (!queue.isEmpty()) {
			int[] now = queue.remove();
			String nowKey = toString(now);
			LinkedList<int[]> nexts = nextMove(now);
			for (int[] next : nexts) {
				String key = toString(next);
				if (map.containsKey(key))
					continue;
				map.put(key, map.get(nowKey)+1);
				queue.add(next);
			}
		}
		int[] finalP = {0,1,2,3,4,5,6,7,8,9};
		String finalKey = toString(finalP);
		if (map.containsKey(finalKey)) {
			System.out.println(map.get(finalKey));
		} else {
			System.out.println(-1);
		}

		scin.close();

	}
}
