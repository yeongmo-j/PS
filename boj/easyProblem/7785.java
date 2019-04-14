"
[문제요약]
사람이 회사에 들어가고 ,나온 목록이 있다
현재시점에 회사에 있는사람들 목록을 사전 역순으로 출력 (측, 들어왔는데, 안나간사람들)

[해결방법]
TreeSet으로 들어온거면, 사람이름 넣어주고
나간거면 사람이름 빼줬다.
단 생성자에 Comparator 넣어주어서 역순으로 정렬되게 해줬다.

Time complexity : O(m*lgm) 각 연산 O(lgm)
Space complexity : O(m)

[추가]
class Comp implements Comparator<String>{
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
}
Set<String> bst = new TreeSet<String>(new Comp());

"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Comp implements Comparator<String>{
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		Set<String> bst = new TreeSet<String>(new Comp());
		while (--m>=0) {
			input = br.readLine().split(" ");
			if(input[1].equals("enter"))
				bst.add(input[0]);
			else
				bst.remove(input[0]);
		}
		for (String str : bst) {
			System.out.println(str);
		}
	}
}
