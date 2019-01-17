'''
[문제요약]
숫자를 이진수로 바꿨을 때, 1이 몇번 나오고, 그게 소수니?

[해결방법]
일단 1 다 더하고, 소순지 판별해야하는데
그 수의 범위를 정하고, 소수 리스트를 만들어줬다.
(잘못생각함)
만약 그 수가 2^20이 안넘으면, 최대가 19이므로, 19이하의 소수만 구해두면 됐는데,
19개의 소수를 구하느라 시간이 오래걸린듯.

Time complexity : O();
Space complexity : O();

[추가]
Integer.bitCount(x)
를 쓰면 1이 몇갠지 그냥 알려준다.
또한 범위 조심할 것!!
19개의 소수를 구하는게 아니라, 19 이하의 소수를 구하는거임!!!!!!
'''
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int n, i, set;
        List<Integer> prime = new LinkedList<Integer>();
        prime.add(2);
        int num=3;
        boolean isPrime;
        int result=0;
        while (prime.size()<=20)
        {
            isPrime = true;
            for (i=0 ; i<prime.size() ; i++)
            {
                if (num%prime.get(i)==0)
                {
                    isPrime=false;
                    break;
                }
            }
            if (isPrime)
                prime.add(num);
            num++;
        }
        for (n=L ; n<=R ; n++)
        {
            set=0;
            String bin = Integer.toBinaryString(n);
            for (i=0 ; i<bin.length(); i++)
                if (bin.charAt(i)=='1')
                    set++;
            if (prime.contains(set))
                result++;
        }
        return result;
    }
}
