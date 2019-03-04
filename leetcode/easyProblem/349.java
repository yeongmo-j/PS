'''
[문제요약]
두 배열중에 교집합 리턴.

[해결방법]
Set 이용

[추가]
set->배열로 바꿀때
itrator는 (int)로 형변환 해줘야 함.
.toArray()는 object[]로 반환되는데, 이는 int[]로 형변환 불가임.
'''
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> array = new HashSet<Integer>();
        int i;
        for (i=0 ; i<nums1.length ; i++)
            set.add(nums1[i]);
        for (i=0 ; i<nums2.length ; i++){
            if (set.contains(nums2[i]))
                array.add(nums2[i]);
        }
        int[] result = new int[array.size()];
        i=0;
        Iterator it = array.iterator();
        while (it.hasNext())
            result[i++]=(int)it.next();
        return result;
    }
}
