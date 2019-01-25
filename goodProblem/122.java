'''
[문제요약]
각 날짜의 가격들이 배열로 주어지고,
어느날에 사고 어느날에 파는걸 반복해서 제일 비싼 수익을 내라.
산날에는 팔수없고, 판날에는 살수없다.

[해결방법]
몰라서 해설봤음.

Time Complexity = O(N); N은 배열의 길이
Space Complecity = O(1);

[추가]
그래프로 보면,
각 극소점에 사서 극대점에 팔면 된다.(최대값, 최소값 아님)
그러므로, 가격이 계속 내려갈때까지 넘어가서,
극소값이면 사고,
그다음날부터 가격이 계속 오르는동안 가지고있다, 극대점에 팔고,
그다음날부터 처음부터 반복하면 된다.

이 때, 루프돌리는법 잘 살펴볼 것.

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
'''
class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int now=0;
        int sum=0;
        boolean toBuy = true;
        int i;
        for (i=0 ; i<prices.length-1 ; i++){
            if (toBuy == true && prices[i]>prices[i+1])
                continue;
            else if (toBuy==true){
                buy = prices[i];
                toBuy=false;
            }
            else if (toBuy == false && prices[i]<prices[i+1])
                continue;
            else{
                sum+=prices[i]-buy;
                toBuy=true;
            }
        }
        if (!toBuy)
            sum+=prices[i]-buy;
        return sum;
    }
}
