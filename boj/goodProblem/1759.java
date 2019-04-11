"
[문제요약]
비밀번호를 만들어야 되는데,
비밀번호는 주어진 알파벳 c개 중에서 l개를 선택한 다음에,
그게 오름차순이면 된다.
모음은 1개, 자음은 2개 이상이여야 한다.

[해결방법]
일단 인풋으로 들어온 알파벳을 정렬 한 뒤에,
재귀함수를 정의해 준다.
go(String password, int i)
는 현재 살펴보는 알파벳의 인덱스는 i이고, 지금까지 만든 패스워드는 password라는 의미이다.
1) 성공할 경우 : password.length() == l
2) 실패할 경우 : i>=c
3) 지금 알파벳을 선택할 경우 : go(password+arr[i], i+1)
4) 지금 알파벳을 선택 안할 경우  : go(password, i+1)
로 해주면 된다.

성공할 경우에 도달하면, 자모음 숫자 세주어서 판별해준다음에 set에 넣어주기
마지막에 set 출력

Time complexity : O(2^l) : 각각 원소를 택하냐, 안택하냐의 경우의 수가 나올 수 있다.
Space complexity : O(c) :스택은 c개 이상 안쌓인다?? 

[추가]

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main{
	static int l;
	static int c;
	static char[] arr;
	static Set<String> set;

	static boolean check(String password) {
		int count=0;
		char[] arr = {'a', 'e', 'i', 'o', 'u'};
		for (char c : password.toCharArray()) {
			for (char aeiou : arr) {
				if (c==aeiou) {
					count++;
					break;
				}
			}
		}
		if (count<1 || l-count<2)
			return false;
		return true;
	}

	static void go(String password, int i) {
		//l:만들어야 하는 암호의 길이, arr:사용할수있는알파벳, password:지금까지만든암호, i :지금 살펴보는ㄴ 인덱스
		if (password.length() == l) {
			//판별하기
			if (check(password)) {
				set.add(password);
			}
		}
		if (i>=arr.length)
			return;
		go(password+arr[i], i+1);
		go(password, i+1);
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		l = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		arr = new char[c];
		int i;
		for (i=0 ; i<c ; i++)
			arr[i] = input[i].charAt(0);
		Arrays.sort(arr);
		set = new TreeSet<String>();

		go("", 0);
		for (String c : set) {
			System.out.println(c);
		}
	}
}
