'''
[문제요약]
369게임

[해결방법]

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''
class Solution {
    public List<String> fizzBuzz(int n) {
        int i;
        List<String> list = new LinkedList<String>();
        for (i=1 ; i<=n ; i++)
        {
            if (i%15==0)
                list.add("FizzBuzz");
            else if (i%3==0)
                list.add("Fizz");
            else if (i%5==0)
                list.add("Buzz");
            else
                list.add(String.valueOf(i));
        }
        return list;

    }
}
