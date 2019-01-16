'''
[문제요약]
문장 2개 주어지고,
각각 띄어쓰기로 구분된 단어들 중에
A에서 한번만! 쓰인 단어
B에서 한번만! 쓰인 단어
그리고, 두 문장 중 한번만 쓰인 단어 판별.

[해결방법]
String.split() 으로 단어 구별.

Time complexity : O(N+M) 각각 단어의 개수.
Space complexity : O(N+M)

[추가]
문제 해석!
A에도 한번만 B에도 한번만 둘중에 하나만 :
전체에서 한번만 쓰이면 된다!!
그러므로 hashmap으로 몇번씩 나왔는지 세면 된다!!!
'''
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<String> list = new LinkedList<String>();
        for (String str : A.split(" "))
        {
            if (map.containsKey(str))
                map.replace(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        for (String str : B.split(" "))
        {
            if (map.containsKey(str))
                map.replace(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        for (String str : map.keySet() )
        {
            if (map.get(str)==1)
                list.add(str);
        }
        int size = list.size();
        String[] result = new String[size];
        for (int i=0 ; i<size ; i++)
            result[i]=list.get(i);
        return result;
    }
}
