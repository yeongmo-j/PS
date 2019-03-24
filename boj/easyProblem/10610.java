"
[문제요약]
숫자 들어오고, 자리수 재배치해서
30의 배수 중에서 제일 큰거 만들기,
못만들면 -1

[해결방법]
30의 배수 = 뒷자리가 0으로 끝나야 함.
그래서 0의 개수 세주기
나머지 숫자들 다 저장해서 더하고, 정렬
자리수 합이 3의 배수 아니면 못만듬 -1
내림차순으로 출력하고 0의 개수만큼 0 출력

Time complexity : O(K)
Space complexity : O(N)

[추가]
30 = 2*3*5인데,
2*5는 10이므로, 항상 0이 뒤에 있어야 한다는 사고 과정

또 0 따로저장하지 말고
역순으로 정렬 해서
맨뒤께 0인지만 확인해도 됨.
"

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scin = new Scanner(System.in);
        String N = scin.next();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int zero = 0;
        int sum=0;
        for (char c : N.toCharArray()) {
        	int now = (int)(c-'0');
        	if (now==0) {
        		zero++;
        	} else {
        		sum+=now;
        		list.add(now);
        	}
        }
        if (zero==0 || sum%3!=0)
        	System.out.println(-1);
        else {
        	Collections.sort(list);
        	Collections.reverse(list);
        	for (int n : list)
        		System.out.print(n);
        	while(--zero>=0)
        		System.out.print(0);
        }

        scin.close();
    }
}
