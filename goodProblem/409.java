"
[문제요약]
문자열이 들어오고, 그원소들로 만들 수 있는 palindrome의 최대 길이를 구하여라.

[해결방법]
문자열의 첫원소부터 탐색해가며 개수를 센다.
대소분자를 구분해야 하므로
2개의 배열(대분자용,소문자용)으로 센다.

그 다음부터 짝수면 좌우대칭 만들 수 있으므로, 더하고,
홀수면, 하나만 덜 써서 좌우대칭을 만들 수 있으므로, 1을 빼서 더한다.

마지막으로, 센것 중에 홀수가 있으면 1을 더한다.(중간에 하나 박으면 된다.)

Time complexity : O(N);
Space complexity : O(1)

[추가]
원소 전체를 다 쓰지 않아도 됨에 주의.
또, 대문자 소문자 셀 때에 그냥
arr[128]로 세버려도 됨.(아스키코드로)

@@@@좋은 방법@@@@@

짝수일때 그대로, 홀수일때 1이 빼지는거면
ans += v/2*2로 가능하다!!
또한, 홀수가 하나라도 있으면 정답에 더하는것또한
if (ans % 2 == 0 && v % 2 == 1)
    ans++;
    로 가능하다는 점.(ans에는 짝수들만 들어간다.
    홀수가 존재하는데도 짝수들만 들어간거면, 1을 더해준다.
    만약 앞에서 이미 1을 더해줬으면 그럴 필요가 없다.)
    @@@@@@@@@@@@

        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }

"


class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char c : s.toCharArray()){
            if (c>='a')
                lower[(int)(c-'a')]++;
            else
                upper[(int)(c-'A')]++;
        }
        int sum=0;
        boolean hasOdd = false;
        for (int i=0; i<26 ; i++){
            if (lower[i]%2==0)
                sum+=lower[i];
            else
                sum+=lower[i]-1;
            if (upper[i]%2==0)
                sum+=upper[i];
            else
                sum+=upper[i]-1;
            if (lower[i]%2!=0 || upper[i]%2!=0)
                hasOdd = true;
        }
        if (hasOdd)
            sum++;
        return sum;
    }
}
