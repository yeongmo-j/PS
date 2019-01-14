'''
[문제요약]
자식이 여러개인 트리 탐색(자식이 list로 되어있음)

[해결방법]
preorder 탐색 해 주었다.

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
    void bfs(Node root, List<Integer> list)
    {
        if (root!=null)
        {
            list.add(root.val);
            for(Node node : root.children)
                bfs(node,list);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        bfs(root,list);
        return list;
    }
}
