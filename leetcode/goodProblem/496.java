'''
[문제요약]
숫자가 중복없이 들어있는 2번배열과 그 부분집합 1번배열이 입력으로 들어온다.
1번배열의 원소를 기준(i번째 )으로, 같은 값을 가진 2번배열의 위치(j번째)에서, 그 오른쪽에 있는것들중 최초로 나오는 값을
값(k)으로 갖는 새로운 배열을 리턴
즉 새로운배열(i)=k

[해결방법]
일단 2번배열과 같은 크기의 새로운 배열을 하나 만든다.
그다음 그 배열[i]의 값은 2번배열[i]의 오른족에서 그보다 큰 최초의 값으로 넣는다.
없으면 -1로 채운다.

1번배열과 같은크기의 정답배열을 만든다.
그다음 1번배열의 앞부터 탐색해가며(i) 2번배열에 어디에 같은값이있는지 찾은뒤에(j)
위에서 새로채운배열(j)의 값을 정답배열(i)에 넣어서
정답배열 리턴.

Time complexity : O(n^2);n은 2번배열의 크기
Space complexity : O(m+n);m은 1번배열의 크기

[추가]
@@@@@@좋은방법
일단 스택을 이용한다.
앞에서부터 차례대로 스택을 넣는데,
만약에 스택의 맨 위에 있는 원소보다 지금 넣으려는게 더 크면,
스택에서 pop 한다. 그 값보다 오른쪽에서 큰 값은 지금 넣으려는 값이 된다!!
그럼 방금 pop한 값을 key로 갖고, 지금 넣으려는 원소를 값으로 갖는 hashmap을 만들어준다!!
그걸 지금 넣으려는거보다 큰게 나올때까지 반복한다...
완료되면 다음 원소로 넘어가서 다시 넣으려는 시도를 한다.
그렇게 끝까지 다 스택에 넣고 나면, 스택에 남아있는 원소들은 다 값을 -1로 갖도록 해준다.

이제 판별하려는 원소들을 하나하나 해쉬맵에서 찾아내주면 된다.
(혹은 스택에 남아있는 원소들은 걍 냅두고 해쉬맵에서 getordefault를 사용하면 된다.)
@@@@@@@@@
Key observation:
Suppose we have a decreasing sequence followed by a greater number
For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

'''
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len2==0 || len1==0)
            return new int[0];
        int[] right = new int[len2];
        int[] result = new int[len1];
        int i, j, num;
        boolean isChanged=false;
        for (i=0 ; i<len2 ; i++)
        {
            isChanged=false;
            for (j=i+1 ; j<len2 ; j++)
            {
                if (nums2[j]>nums2[i])
                {
                    isChanged=true;
                    right[i]=nums2[j];
                    break;
                }
            }
            if (!isChanged)
                right[i]=-1;
        }
        for (i=0 ; i<len1 ; i++)
        {
            num = nums1[i];
            for (j=0 ; j<len2 ; j++)
            {
                if (nums2[j]==num)
                {
                    result[i]=right[j];
                    break;
                }
            }
        }
        return result;
    }
}
