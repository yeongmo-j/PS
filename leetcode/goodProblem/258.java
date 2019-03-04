'''
[문제요약]
숫자가 주어지고, 각 자리수 숫자들 다 더하는거 반복해서 일의자리 나올때까지 더하기.


[해결방법]
루프돌려서 구한다.

Time complexity : O(logN);
Space complexity : O(1);

[추가]
루프 없이 O(1)에 구할 수 있어야 한다.

class Solution {
    public int addDigits(int num) {
    if(num==0){
		return 0;
    }
	if(num%9==0){
		return 9;
    }
	return num%9;
    }
}

'''
class Solution {
    public int addDigits(int num) {
        int sum=num;
        while (sum>=10){
            num=sum;
            sum=0;
            while (num!=0){
                sum+=num%10;
                num=num/10;
            }
        }
        return sum;
    }
}
