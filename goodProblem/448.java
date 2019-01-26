"
[문제요약]
배열이 주어지는데, 그 길이가 n이라고 하면
원소들은 모두 1과 n사이에 있다(포함)
[1,n]사이에서 한번도 안나온 원소들을 골라서 리턴해라.

공간은 쓰면 안되고, 시간복잡도는 O(N)이여야 한다.

[해결방법]
못풀어서 해설 봤음.
앞에서부터 탐색하며 나온 숫자의 인덱스에 표시를 한다.
표시는 그 해당하는 인덱스의 값을 음수로 바꿔주는 것이다.(양수도 음수로, 음수는 그대로 음수로)
바꿔줘야 한다.
인덱스 찾아가는걸 잘 해야 함!!!
매우 좋은 문제라고 생각함.

[추가]
@@@@@좋은방법@@@@@
위에 써있다.
"
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i, val;
        int len = nums.length;
        List<Integer> result = new LinkedList<Integer>();
        for (i=0 ; i<len ; i++){
            val = Math.abs(nums[i])-1;
            if (nums[val]>0)
                nums[val]=-1*nums[val];
        }
        for (i=0 ; i<len ; i++){
            if (nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}
