"
[문제요약]
N개의 정수 배열이 들어오고,
한번에 N-1개의 원소들을 1씩 늘린다.
몇번해야 다 똑같아지나?

[해결방법]
N-1개 1씩 증가하는거 : 하나를 1 줄이는거랑 같다.
즉 한번에 하나씩 줄여서 다 같아지는거 : 제일 작은거로 맞춰야 한다.
결론 : 한번에 하나씩 1씩 줄여서 제일 작은 원소로 맞춰라.

그래서 제일 작은 원소 찾아서,
나머지 원소들 탐색하며 제일 작은거랑 몇씩 차이나는지 다 더하기.

Time complexity : O(N);
Space complexity : O(1)

[추가]
최소값 구할 때 정렬해서 시간이 오래걸렸는데, 그럴 필요 없이,
N 탐색 해서 최소값을 찾는게 좋다.
Integer.MAX_VALUE
로 최대값 설정한 후 최소값 구하기.
"
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n: nums)
            if (n<min)
                min = n;
        int sum = 0;
        for (int n : nums)
            sum+=n-min;
        return sum;
    }
}
