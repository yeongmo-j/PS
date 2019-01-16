'''
[문제요약]
2진수로 변환하여,
바로 뒤에 오는 1과의 차이 중에 제일 큰 것.(사이에 0만 있어야되고 1은 있으면 안됨)

[해결방법]
일단 리스트에 2진수로 변환해서 넣어준다음에,
앞에서부터 탐색한다.
front는 전에 나온 인덱스 저장
만약 front가 -1이 아니면, 앞에서 나왔다는 의미이므로,
최대값과 비교함(i-front로)

Time complexity : O(lgN) N은 숫자이고 이진수로 바꾸는데 lgN만큼 들고 리스트 크기고 이만큼이므로
Space complexity : O(lgN) 이진수로 변환했을때 리스트의 크기

[추가]
'''
class Solution {
    public int binaryGap(int N) {
        List<Integer> list = new ArrayList<Integer>();
        if (N==0)
            return 0;
        while (true)
        {
            list.add(N%2);
            N/=2;
            if (N==0)
            {
                list.add(0);
                break;
            }
        }
        int front=-1, i, max=0;
        int size = list.size();
        for (i=0 ; i<size ; i++)
        {
            if (list.get(i)==1)
            {
                if (front==-1)
                    front=i;
                else
                {
                    if (i-front>max)
                        max = i-front;
                    front = i;
                }
            }
        }

        return max;
    }
}
