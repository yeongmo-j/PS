'''
[문제요약]
배열 안에서 중복인거 찾기

[해결방법]
하나하나 HashSet으로 넣은다음에
중복인거 나오면 그거 리턴해줬다.

time complexity : O(N);
space complexity : O(N);

[추가]
'''

class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> hashSet = new HashSet<Integer>();
        int size = A.length;
        int i, temp;
        for (i=0 ; i<size ; i++)
        {
            temp = A[i];
            if (hashSet.contains(temp))
                return temp;
            hashSet.add(temp);
        }
        return -1;
    }
}
