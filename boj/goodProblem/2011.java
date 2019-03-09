"
[문제요약]
A=1 Z=26으로 문자열을 암호화하였다.
이렇게 되면 숫자로만 이루어지게 되는데,
이를 다시 알파벳으로 변환시킬 때, 여러가지 경우의 수가 나올 수 있다.
25114를 다시 영어로 바꾸면,
"BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN" 총 6가지가 나오는 것처럼

이 때, 숫자가 들어오고, 이를 알파벳으로 해석할 수 있는 방법의 수를 리턴ㄴ하여라.

[해결방법]
케이스를 나눠 생각해 봤다.
d[i] 는 i번째 숫자가 마지막 숫자일 때의 경우의 수라고 정의를 하면,
A[i]가 0이면, 앞에 숫자와 이어지는 꼭 두자리 숫자여야 한다.
그러므로,d[i] = A[i-1]이 1이나 2일경우 , d[i-1] 이 되고, 아닐 경우 0이 된다.(불가능)
A[i]가 0이 아닐 경우를 살펴보면, 일단 그 숫자가 한자리 숫자일 경우로 보자.
그렇게 되면 d[i] = d[i-1]로 시작이 된다.
그 다음에, 두자리 숫자일 경우로 생각해 주면 된다.
두자리 숫자일 경우 A[i-1]이 1이면, d[i-2]를 더해준다.
또 A[i-1]이 2이면, A[i]가 1과 6 사이일 경우 d[i-2]를 더해준다.

if (c[1]!='0') {
  d[0] = 1;
  for (int i=1 ; i<=lastIdx ; i++) {
    if (c[i]=='0') {
      if (c[i-1]!='1' && c[i-1]!='2') {
        d[lastIdx]=0;
        break;
      }
      else {
        d[i] = d[i-2];
      }
    } else {
      d[i] = d[i-1];
      if (c[i-1]=='1')
        d[i]+=d[i-2];
      if (c[i-1]=='2' && c[i]>='1' && c[i]<='8')
        d[i]+=d[i-2];
    }
    d[i]%=1000000L;
  }
}


Time complexity : O(N)
Space complexity : O(N);

[추가]


"

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Scanner scin = new Scanner(System.in);
		String s = scin.next();
		s = " " + s;
		char[] c = s.toCharArray();
		int lastIdx = c.length-1;
		long[] d = new long[lastIdx+1];
		if (c[1]!='0') {
			d[0] = 1;
			for (int i=1 ; i<=lastIdx ; i++) {
				if (c[i]=='0') {
					if (c[i-1]!='1' && c[i-1]!='2') {
						d[lastIdx]=0;
						break;
					}
					else {
						d[i] = d[i-2];
					}
				} else {
					d[i] = d[i-1];
					if (c[i-1]=='1')
						d[i]+=d[i-2];
					if (c[i-1]=='2' && c[i]>='1' && c[i]<='8')
						d[i]+=d[i-2];
				}
				d[i]%=1000000L;
			}
		}
		System.out.println(d[lastIdx]);
		scin.close();
	}
}
