"
[문제요약]
회의가 N개 잡혔는데, 시작시간과 종료시간이 주어졌다.
하나의 회의실로 시간이 겹치지 않게 최대한 많은 회의를 하는 개수를 구하여라.
끝나자마자 바로 시작해도 된다.

[해결방법]
1. 일단 어떻게해야 최대한 많이 고를 수 있을까?
    - 먼저 시작하는거부터 해볼까 ? : 늦게시작하지만 1시간짜리 3개있는게 빨리시작하지만 10시간
    짜리보다 더 좋다. 안됨
    - 그럼 길이가 짧은거부터 해볼까? : 긴거 2개랑, 그 중간에 겹쳐있는 짧은거랑 긴거 2개하는게 더
    이득임. 안됨
    - 그렇다면 빨리 끝나는거부터 해볼까? : 정답인데 증명해야 함.
    일찍끝나는 회의를 먼저 선택하면, 늦게끝나는회의보다 끝나고 난뒤의 공간이 넓어짐 : 즉
    선택권의 범위가 넓어진다.
    그리고, 최적해가 있고, 그리디 알고리즘이 있다고 할 때, 최적해와 그리디알고리즘의
    다른 선택지의 각 회의에 대해, 그리디의 더 일찍 끝나는 회의를 선택한다고 해도, 정답의
    개수는 변하지 않는다.(더 일찍 끝나므로 뒤에 영향을 안미침)
    즉. 이 문제는 그리디 알고리즘으로 풀 수 있고, 선택지는 남은 시간 중에 제일 일찍 끝나는 회의다.

2. 가장 먼저끝나는 회의
    -가장 먼저끝나는 회의를 고르기 위해선 정렬을 해줘야 한다.
    시작시간과 종료시간을 담고있는 클래스를 하나 만들어주고,
    종료시간 더 빠른게 앞에오도록 comparable 구현 해준다.
    @@여기서 문제@@
    그냥 종료시간만 가지고 구현을 해주면 안된다.
    만약, 종료시간이 같으면, 시작시간이 더 빠른걸로 해줘야 한다!
    왜냐면, 문제에서 시작하자마자 종료하는 회의가 있다고 했는데,
    (2,2)(2,2)(1,2)라는 시간이 있으면,
    (1,2)(2,2)(2,2)로 3번을 할 수 있는데 순서가 바뀌면 그러지 못하기 떄문이다.

3. 정렬을 했으면 종료시간 다음에 시작하는거 찾아서 1 추가해주고 반복해주면 된다.

Time complexity : O(NlgN) (정렬)
Space complexity : O(N)

[추가]
좋음

"

import java.util.Arrays;
import java.util.Scanner;

class Time implements Comparable<Time>{
    int start;
    int end;
    Time(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(Time another) {
    	if (this.end<another.end)
    		return -1;
    	if (this.end == another.end) {
    		if (this.start == another.start)
    			return 0;
    		if (this.start < another.start)
    			return -1;
    	}
    	return 1;
    }
}

public class Main{
    static Time[] meetTime;


    public static void main(String[] args){
    	Scanner scin = new Scanner(System.in);
        int N = scin.nextInt();
        meetTime = new Time[N];
        int i;
        for (i=0 ; i<N ; i++){
            int a = scin.nextInt();
            int b = scin.nextInt();
            meetTime[i] = new Time(a,b);
        }
        Arrays.sort(meetTime);
        int lastTime = 0;
        int count=0;
        for (i=0 ; i<N ; i++){
            if (meetTime[i].start>=lastTime){
                count++;
                lastTime = meetTime[i].end;
            }
        }
        System.out.println(count);
        scin.close();
    }
}
