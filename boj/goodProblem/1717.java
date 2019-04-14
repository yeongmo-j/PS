"
[문제요약]
union/ find 연산 구현

[해결방법]
static int[] parent;

static int find(int x) {
    if (x==parent[x])
        return x;
    else {
        int y = find(parent[x]);
        parent[x] = y;
        return y;
    }
}

static void union(int x, int y) {
    int a = find(x);
    int b = find(y);
    parent[b] = a;
}


Time complexity : O(m) 각 연산 O(1)
Space complexity : O(n)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] parent;

	static int find(int x) {
		if (x==parent[x])
			return x;
		else {
			int y = find(parent[x]);
			parent[x] = y;
			return y;
		}
	}

	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		parent[b] = a;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		parent = new int[n+1];
		int i;
		for (i=0 ; i<=n ; i++)
			parent[i] = i;
		while (--m>=0) {
			input = br.readLine().split(" ");
			int menu = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			if (menu==0)
				union(x, y);
			else {
				if (find(x)==find(y)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
