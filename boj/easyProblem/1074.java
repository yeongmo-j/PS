"
[문제요약]
만약 2*2배열이면
0 1
2 3
이순서대로 탐색을 한다.
행,렬의 길이는 2의 멱수이고, 이렇게 4등분씩 하면서 탐색을 한다고 할 때,
0 1     4 5
2 3     6 7

8 9     12 13
10 11   14 15
이런식으로 탐색을 한다.
가로,세로의 길이는 2^N이고 무조건, N과 r,c(행,열의 인덱스) 가 주어질 때,
이 점을 몇번째로 탐색하는지?

[해결방법]
탐색을 분할해서 4등분으로 탐색을하니까.
구현도 그렇게 해준다.
인덱스 범위롤 인자로 받고,
4등분 했을 때, r,c가 몇번째 사분면에 속하는지 알아내서

전체 범위 원소의 개수의 4분의 1을 quarter라고 할 때,
quarter*i번째사분면 + 4등분해서 해당 사분면의 좌표에 대한 재귀값
을 리턴 해주면 된다.

Time complexity : O(log_4^N);
Space complexity : O(log_4^N)

[추가]

"
import java.io.*;


public class Main{

	static int count(int ist, int ien, int jst, int jen, int r, int c){
		int len = (ien-ist+1);
		if(len<=1)
			return 0;
		int quarter = (len/2)*(len/2);
		int imid = ist+len/2-1;
		int jmid = jst+len/2-1;
		if (r<=imid ){
			if (c<=jmid){
				return count(ist, imid, jst, jmid, r, c);
			} else {
				return quarter + count(ist, imid, jmid+1, jen, r, c);
			}
		} else {
			if (c<=jmid ){
				return quarter*2 + count(imid+1, ien, jst, jmid,r, c);
			} else {
				return quarter*3 + count(imid+1, ien, jmid+1, jen, r, c);
			}
		}

	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int r = Integer.parseInt(temp[1]);
		int c = Integer.parseInt(temp[2]);
		int lastIdx = (1<<N)-1;
		System.out.println(count(0,lastIdx,0,lastIdx, r, c));

	}
}
