"
[문제요약]
a^b 구하기
[해결방법]
재귀

Time complexity : O(lgb)
Space complexity : O(lgb)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	static long run(long a, long b, long c) {
		if (b==0) {
			return 1;
		} else if (b==1) {
			return a%c;
		} else if (b%2==0){
			long temp = run(a, b/2, c);
			return temp*temp%c;
		} else {
			long temp = run(a, (b-1)/2, c);
			return ((a*temp)%c)*temp%c;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		long c = Long.parseLong(input[2]);
		System.out.println(run(a, b, c));
	}

}
