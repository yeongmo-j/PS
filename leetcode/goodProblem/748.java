'''
[문제요약]
일단 기준 문자열 하나가 주어지고(영+숫)
이중에서 영어만 빼낸다.
 그다음에 문자열 배열이 주어지고 ,이 배열의 원소 중에 위에서 구한 영어들을 다 포함하고 있는것중에
 길이 제일 짧은거 고르기.
s가 두번있으면 두번 이상 들어있는거 골라야 함.

[해결방법]
다 해봤다.

Time complexity : O(N*M*K)N은 기준 문자열 길이, M은 배열 크기 K는 제일 큰 문자열의 길이(매우 느리다)
Space complexity : O(N);

[추가]
@@@@좋은 방법@@@@@@
알파벳 a부터 z까지를 소수에 대응시킨다.
그다음에 기준문자열에서 알파벳 뽑아내서 해당하는 소수들을 서로 곱해준다.

그다음 문자열 배열 원소들도 같은 방법으로 대응하는 소수들 다 곱해준다.
이 수에서 위에서 구한 소수들이 곱이 나누어 떨어지면 포함하는 것이다!!!!!!!!!!!!!!!

하지만 z에 해당하는 소수는 100이 넘으므로 오버플로우 발생가능성.

int minLength = Integer.MAX_VALUE;
로 정수 최대값 구할 수 있음!

'''
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        LinkedList<Character> list = new LinkedList<Character>();
        int i, len, idx;
        for (char c : licensePlate.toCharArray()){
            if (c>='a' && c<='z'){
                list.add(c);
            }
        }
        len = list.size();
        String temp;
        int minLen=5000;
        String result ="", ss;
        boolean bool=false;
        for (String s : words){
            ss = s.toLowerCase();
            bool = true;
            for (i=0 ; i<len ; i++){
                idx = ss.indexOf(list.get(i));
                temp = "";
                if (idx>=0){
                    if (idx>=1)
                        temp+=ss.substring(0,idx);
                    if (idx+1<=ss.length()-1)
                        temp+=ss.substring(idx+1);
                    ss = temp;
                }
                else{
                    bool = false;
                    break;
                }
            }
            if (bool){
                if (s.length()<minLen){
                    minLen = s.length();
                    result = s;
                }
            }
        }
        return result;
    }
}
