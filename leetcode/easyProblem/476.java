'''
[문제요약]
정수 하나 주어지고,
그거의 2진수를 반전시켜 다시 10진수로 반환

[해결방법]
입력과 출력의 합이 결국 입력보다 큰 2의 지수승보다 1 작은걸 이용
input+output = 2^k-1

Time complexity : O(lgN) 여기서 N은 정수의 크기
Space complexity : O(1);

[추가]
2씩 곱해주기 때문에 오버플로우가 날 수 있음!
long으로 선언 해주자.
'''
class Solution {
    public int findComplement(int num) {
        if (num==0)
            return 1;
        long compare=1;
        do
        {
            compare*=2;
        } while (num>=compare);
        return (int)(compare-1-num);

    }
}
