"
[문제요약]
알파벳 개수 세기.

[해결방법]

Time complexity : O(N)
Space complexity : O(1);

[추가]
"
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);

		int[] count = new int[26];
		String str = scin.next();
		for (char c : str.toCharArray())
			count[(int)(c-'a')]++;
		StringBuffer sb = new StringBuffer();
		sb.append(count[0]);
		for (int i=1 ; i<26 ; i++) {
			sb.append(" ");
			sb.append(count[i]);
		}
		System.out.println(sb);
		scin.close();
	}
}
