'''
[문제요약]
정수로 이루어진 배열이 들어오고,
부분 배열 중에, maximum value와 minimum value의 차이가 정확히 1인 최대 크기를 구하여라.

즉 : 원소들이 1차이나는 원소들 2개로 다 이루어져있어야 한다.


[해결방법]
일단 treemap으로 원소를 키로 하고 개수를 값으로 하는 맵을 만든다.
treemap의 키는 자동 정렬되므로, 근접해있는 키와 비교하여,
둘의 키 차이가 1이면 둘 원소의 합을 구한다.
이중 최대값을 구하라.

Time Complexity = O(NlgN); :트리맵 만들기
Space Complecity = O(N);

[추가]
TreeMap은 키가 정렬된다!


'''

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int n : nums){
            if (!map.containsKey(n))
                map.put(n,1);
            else {
                map.put(n,map.get(n)+1);
            }
        }
        Set<Integer> set = map.keySet();
        Integer[] keyset = new Integer[set.size()];
        set.toArray(keyset);
        int max = 0;
        int diff=0;
        int sum=0;
        for (int i=1 ; i<keyset.length ; i++){
            diff = keyset[i]-keyset[i-1];
            if (diff==1 || diff==-1){
                sum = map.get(keyset[i])+map.get(keyset[i-1]);
                max = max<sum ? sum : max;
            }
        }
        return max;
    }
}
