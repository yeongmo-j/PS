"
[문제요약]
문자열 과, 폭탄이 들어오고(폭탄도 문자열)
문자열에서 폭탄이 있으면 ,그부분 없애버린다. 그 뒤에 연쇄가 가능하다(없어진 후에 결과에서도
폭탄이 생기면 계속 연쇄 가능)

이렇게 됐을 때, 모든 폭발이 끝나고 마지막 결과를 출력해라.


[해결방법]
stack에 문자열 한글자씩 넣어주고서, 만약 방금 넣은게 폭탄 마지막글자와 같으면 stack에서 맨위에있는것들을 확인한다.
확인해서 폭탄과 같으면 그부분 없애주고, 다르면 다시 넣어준다.


Time complexity : O(문자열길이*문자열길이 ?)
Space complexity : O()

[추가]
맨처음에 스택에 넣을때마다 검사해줬더니, 시간초과
그래서 폭탄 마지막 글자와 일치할떄만 검사하도록 했더니, 성공하였다.
그런데 이것도 살펴보니까 시간복잡도가(전체 문자열 길이 * 마지막글자가 반복되는 악의가 있을 때 매번 검사하는 전체문자열길이) 여서
별 차이가 이론상으로는 없다.

해결방법 : 문자열인덱스와, 폭탄 인덱스를 따로 관리한다.
각각의 인덱스를 일치하면 1씩 늘려가며 스택에 넣고, 마지막까지 도달하면 스택에서 뺴준다
지금 이거넣을차롄데 다른게 들어오면 인덱스를 초기화해주면 된다.
이 떄, 스택에 원소를 넣는게 아니라, 인덱스의 쌍을 넣는것에 주의. 그래야 폭탄 폭발하고 나서,
그 맨위에서부터 다시 이어갈 수 있음.(폭탄의 인덱스)

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        boolean[] erased = new boolean[n];
        //폭탄이 한글자면 그냥 for문으로 돌리기
        if (m == 1) {
            for (int i=0; i<n; i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    erased[i] = true;
                }
            }
        } else {
            Stack<Pair> s = new Stack<Pair>();
            for (int i=0; i<n; i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    s.push(new Pair(i, 0));
                } else {
                    if (!s.empty()) {
                        Pair p = s.peek();
                        if (a.charAt(i) == b.charAt(p.second+1)) {
                            s.push(new Pair(i, p.second+1));
                            if (p.second+1 == m-1) {
                                for (int k=0; k<m; k++) {
                                    Pair top = s.pop();
                                    erased[top.first] = true;
                                }
                            }
                        } else {
                            while (!s.empty()) {
                                s.pop();
                            }
                        }
                    }
                }
            }
        }
        boolean printed = false;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (erased[i]) {
                continue;
            }
            sb.append(a.charAt(i));
            printed = true;
        }
        if (printed) {
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }
    }
}


"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int n;
	static int[] arr;
	static int s;
	static int count;

	static void run(int sum, int k, int len) {
		//지금까지 모은 점수가 sum이고, k번째를 탐색중, 지금까지 모은 원소의 수는 len
		if (k>=n) {
			if (sum==s && len>0)
				count++;
			return;
		}
		run(sum+arr[k], k+1, len+1);
		run(sum, k+1, len);

	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		count=0;
		arr = new int[n];
		input = br.readLine().split(" ");
		int i;
		for (i=0 ; i<n ; i++)
			arr[i] = Integer.parseInt(input[i]);
		run(0, 0, 0);
		System.out.println(count);
	}
}
