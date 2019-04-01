"
[문제요약]
집합 연산 하기
(원소의 범위가 1~20까지로 정해져 있음)

[해결방법]
비트마스크 이용
집합을 비트로 관리하는거
각 연산이 가능함 (중급1 - 완전탐색 0 에 들어있음)

Time complexity : O(N) (N개의 연산) 각 연산당 O(1)만큼 걸림
Space complexity : O(N)

[추가]
출력할 때 느리니까
StringBuilder로 한꺼번에 모아놨다가
출력

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Set{
	int set;
	Set(){
		set = 0;
	}
	void add(int x) {
		set = set | 1<<x;
	}
	void remove(int x) {
		set = set & ~(1<<x);
	}
	int check(int x) {
		if ((set & 1<<x) == 0)
			return 0;
		return 1;
	}
	void toggle(int x) {
		set = set ^ 1<<x;
	}
	void all() {
		set = (1<<21)-1;
	}
	void empty() {
		set = 0;
	}
}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int m = Integer.valueOf(in[0]);
		Set bitmask = new Set();
		StringBuilder sb = new StringBuilder();
		while(--m>=0) {
			in = br.readLine().split(" ");
			String order = in[0];
			if (order.equals("all")) {
				bitmask.all();
			} else if (order.equals("empty")) {
				bitmask.empty();
			} else {
				int x = Integer.valueOf(in[1]);
				switch(order) {
				case "add" :
					bitmask.add(x);
					break;
				case "remove" :
					bitmask.remove(x);
					break;
				case "toggle" :
					bitmask.toggle(x);
					break;
				case "check" :
					sb.append(bitmask.check(x) + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
