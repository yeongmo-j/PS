"
[문제요약]
파스칼의 삼각형 만들기
숫자가 주어지면,
삼각형 맨위는 1하나
두번째는 1두개
세번째는 1 2 1
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

이렇게 만들어라

[해결방법]
재귀로 레벨 1씩 늘려가며, 전에 리스트에서 뽑아와서 함.

Time complexity : O(N^2) 총 원소의 수는 N(N+1)/2;
Space complexity : O(N^2);

[추가]
"
class Solution {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    void pascal(int n, int i){
        if (n<=i)
            return;
        List<Integer> tri = new LinkedList<Integer>();
        tri.add(1);
        for (int j=0; j<i-1 ; j++)
            tri.add(list.get(i-1).get(j)+list.get(i-1).get(j+1));
        if (i!=0)
            tri.add(1);
        list.add(tri);
        pascal(n, i+1);
    }


    public List<List<Integer>> generate(int numRows) {
        pascal(numRows, 0);
        return list;
    }
}
