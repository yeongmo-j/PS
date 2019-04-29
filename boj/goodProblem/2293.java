"
[문제요약]
n종류의 동전이 있을 떄, k원을 만드는 방법의 수를 구하여라
동전을 사용한 순서에 상관없이 똑같은 동전을 똑같은 개수만큼 쓰면, 한번으로 취급

[해결방법]
DP이용
d[i]= i원을 만들 수 있는 가지수
일단 동전종류 같은동전개수는 하나로 취급하므로, 이걸 주의해야 한다
그래서 동전 하나씩 채워나가기로 함.
일단 d[동전[i]]를 1 늘려주고 시작
그다음에 d[1]~d[k-1]까지 1 이상이면
거기서 d[j+동전[i]]+=d[j] 로 동전을 더해준다.
이렇게 되면 i번째 동전을 사용해서 채울 수 있는 모든 경우의 수가 채워짐.
왜냐면? 앞에서부터 계속 채워지므로, 1번쓰고 ,2번쓰고 ,3번쓰고 이렇게 점점 알아서 늘어나짐
이걸 동전 0부터 n-1까지 루프 돌려주면 된다

int[] d = new int [k+1];
for (i=0 ; i<n ; i++) {
    if (coins[i]<=k) { //동전이 범위를 넘을 수도 있으니까
        d[coins[i]]++; //동전 하나 썼을때 추가
        for (j=1 ; j<k ; j++) {
            if (j+coins[i]>k) //범위 넘으면 다음 동전으로
                break;
            if (d[j]!=0) { //앞에서 만들 수 있는 수면 이번 동전 쓴만큼 뒤에다 더해주기
                d[j+coins[i]]+=d[j];
            }
        }
    }
}

Time complexity : O(n*k)
Space complexity : O(n+k)

[추가]

"
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int[] coins = new int[n];
		int i, j;
		for (i=0 ; i<n ; i++)
			coins[i] = Integer.parseInt(br.readLine().trim());
		int[] d = new int [k+1];
		for (i=0 ; i<n ; i++) {
			if (coins[i]<=k) {
				d[coins[i]]++;
				for (j=1 ; j<k ; j++) {
					if (j+coins[i]>k)
						break;
					if (d[j]!=0) {
						d[j+coins[i]]+=d[j];
					}
				}
			}
		}
		System.out.println(d[k]);
	}
}
