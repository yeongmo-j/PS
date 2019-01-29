"
[문제요약]
두 배열이 주어지고,
두 배열의 공집합을 구하라.
같은수가 여러개 겹치면 결과도 여러개 겹쳐야 함.

[해결방법]
map을 두개 만들어서
각각 원소 개수 세준다.
그래서 첫번쨰 map 탐색하며, 2에도 존재하면, 둘중에 더 작은거만큼 결과에 추가해준다.

Time complexity : O(N+M);
Space complexity : O(N+M);

[추가]
@@@@좋은방법@@@@@
맵을 2개 만들지 말고,
하나만 만든 다음에,
두번째 배열 탐색하며
원소가 맵에 존재하면, 리스트에 추가하고 개수 하나 빼주는 형식으로 가면 루프를 더 줄일 수 있다.
"
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();
        for (int num : nums1){
            if( map1.containsKey(num))
                map1.replace(num, map1.get(num)+1);
            else
                map1.put(num,1);
        }
        for (int num : nums2){
            if (map2.containsKey(num))
                map2.replace(num, map2.get(num)+1);
            else
                map2.put(num,1);
        }
        int from1, from2;
        for(int key : map1.keySet()){
            if (map1.containsKey(key)){
                from1 = map1.get(key);
                from2 = map2.containsKey(key) ? map2.get(key) : 0;
                if (from2!=0){
                    for (int i=0 ; i<Math.min(from1,from2) ; i++)
                        list.add(key);
                    map2.remove(key);
                }
            }
        }
        int[] result = new int[list.size()];
        int i=0;
        for (int num : list)
            result[i++]=num;
        return result;
    }
}
