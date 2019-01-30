"
[문제요약]
2진법으로 나타내는 시계가 있다.
시간은 4비트, (0~11)
분은 6비트로 표현한다. (0~59)
각 비트는 led로 표시하는데,
총 led를 켤 수 있는 개수가 주어지면,
모든 표현 가능한 시간들을 표현해라.

[해결방법]
시간4+분6=10짜리 배열을 가지고
순열을 만들었다.
int[] num = {8,4,2,1,32,16,8,4,2,1};
그 뒤, 각 인덱스에 해당하는 숫자들로 시간,분을 만들어줬다.

@@@@너무 구림@@@@

Time complexity : O();
Space complexity : O()

[추가]
@@좋은방법@@
public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++)
        for (int m=0; m<60; m++)
            if (Integer.bitCount(h * 64 + m) == num)
                times.add(String.format("%d:%02d", h, m));
    return times;
}
일단 시간 가능한 조합 수를 모두 루프 돌린 다음에, 그걸 비트로 만들어서 카운트한다.
64를 곱해주는 이유는, 분의 최대단위가 32이기 때문에, 그 다음 큰 단위인 64를 곱해줬다.

"

class Solution {
    int[] num = {8,4,2,1,32,16,8,4,2,1};
    int[] watch = new int[10];
    List<String> list = new LinkedList<String>();
    void run(int idx, int left){
        if (idx>=10 && left!=0)
            return;
        if (idx>=10 || left==0){
            int hour=0;
            int min=0;
            for (int i=0 ; i<4 ; i++){
                if (watch[i]==1)
                    hour+=num[i];
            }
            for (int i=4 ; i<10 ; i++){
                if (watch[i]==1)
                    min+=num[i];
            }
            String temp = hour + ":";
            if (hour>11 || min>59)
                return;
            if (min<10)
                temp +="0"+min;
            else
                temp+=min;
            list.add(temp);
            return;
        }
        run(idx+1, left);
        watch[idx]=1;
        run(idx+1, left-1);
        watch[idx]=0;
    }

    public List<String> readBinaryWatch(int num) {
        run(0, num);
        return list;
    }
}
