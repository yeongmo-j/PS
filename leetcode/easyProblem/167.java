"
[문제요약]
정렬된 배열이 들어오고,
타겟이 들어온다,
이중에 두개를 합해서 타겟이 되는 인덱스 2개를 구하여라.
답은 꼭 있음. 중복사용 불가.

[해결방법]
일단 맨앞꺼와 맨뒤꺼를 더한다.
이게 타겟보다 크면, 더 줄여아한다 -> 맨뒤꺼를 그 앞꺼로 바꾼다
이게 타겟보다 더 작으면 ->맨앞꺼를 그 다음꺼로 바꾼다
타겟과 일치한다 -> 리턴

Time complexity : O(N);
Space complexity : O(1);

[추가]

"
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int front=0 , back = numbers.length-1, sum=0;;
        while(front<back){
            sum = numbers[front]+numbers[back];
            if (sum==target){
                result[0]=front+1;
                result[1]=back+1;
                break;
            }
            else if (sum>target)
                back--;
            else
                front++;
        }
        return result;

    }
}
