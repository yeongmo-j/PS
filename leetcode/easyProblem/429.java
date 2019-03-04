'''
[문제요약]
트리 같은레벨에 있는 노드들 묶음으로 구성되어있는 리스트 만들기.

[해결방법]
인자로 몇번째 레벨인지도 같이 받아서,
리스트의 그 인자에 해당하는 순서에 추가해 주었다.

Time complexity : O(N);
Space complexity : O(N);

[추가]

'''
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<List<Integer>> bigList;
    void level(Node root, int i)
    {
        if (root!=null)
        {
            if (bigList.size()<=i)
            {
                List<Integer> smallList = new LinkedList<Integer>();
                bigList.add(smallList);
            }
            bigList.get(i).add(root.val);
            if (root.children!=null)
                for(int j=0 ; j<root.children.size() ; j++)
                    level(root.children.get(j),i+1);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        bigList = new LinkedList<List<Integer>>();
        level(root,0);
        return bigList;
    }
}
