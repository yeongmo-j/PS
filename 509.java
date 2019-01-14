'''
[문제요약]
피보나치 구하기.

[해결방법]
행렬 방법으로 했다.

Time complexity : O(N);
Space complexity : O(N);

[추가]
그냥 bottom up으로 루프 돌리는게 제일 빠르고 공간도 덜잡아먹음.
연습용으로 해보았다.
'''

class Int
{
    int n;
    Int(int n)
    {
        this.n = n;
    }
    void change(int n)
    {
        this.n = n;
    }
    int get() {return n;}
}

class Solution {
    int fibonacci(int n, Int a, Int b, Int c, Int d)
    {
        int w, x, y, z;
        if (n>0)
        {
            w = a.get() + b.get();
            x = a.get();
            y = c.get() + d.get();
            z = c.get();
            a.change(w);
            b.change(x);
            c.change(y);
            d.change(z);
            return fibonacci(n-1, a, b, c, d);
        }
        else
            return b.get();
    }

    public int fib(int N) {
        int result;
        if (N==0) return 0;
        else
            return fibonacci(N-1, new Int(1), new Int(1), new Int(1), new Int(0));
    }
}
