'''
[문제요약]
왼 오 위 아래 로 방향조작 여러개가 문자열로 들어오고,
결국 원점으로 돌아오는지?

[해결방법]
x, y좌표를 변수로 놔둔뒤에
그냥 문자열 원소 하나하나 살펴봐서 위면 y+1, 아래면 y-1 이런식으로 해주고
결국 0,0으로 돌아오는지?

N이 문자열의 길이일 때,
Time complexity : theta(N);
Space complexity : theta(1) (toCharArray면 theta(N))

[추가]
문자열을 char 배열로 바꿔줄 때 toCharArray()
쓰면 너무 좋다!
이걸로 for each 돌리면 코드가 훨씬 짧아진다.
또한 결과값 리턴 할 때, return x == 0 && y == 0;
그냥 이런식으로 해도 훨씬 짧아진다!

switch문도 너무 길어질땐 그냥 if-elseif로 쓰자.
'''
class Solution {
    public boolean judgeCircle(String moves) {
        int x=0, y=0;
        int size = moves.length();
        for (int i=0 ; i<size ; i++)
        {
            switch(moves.charAt(i))
            {
                case 'U' :
                    y++;
                    break;
                case 'D' :
                    y--;
                    break;
                case 'L' :
                    x--;
                    break;
                case 'R' :
                    x++;
            }
        }
        if (x==0 && y==0)
            return true;
        else
            return false;
    }
}
