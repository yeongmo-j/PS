"
[문제요약]
루트에서 모든 리프노드까지의 경로를 출력.

[해결방법]
bfs를 하는데, 인자로 현재까지의 경로를 string으로 넣어준다.
그리고 다음 재귀에 도착해서는, 거기에 현재 값을 추가하고, 또 자식들로 재귀시켜준다.
리프노드에 와서 결과리스트에 추가해준다.

Time complexity : O(N);
Space complexity : O(N);

[추가]

"/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<String> list = new LinkedList<String>();

    void run(TreeNode root, String s){
        if (root==null)
            return;
        String str = s + root.val;
        if (root.left==null&&root.right==null){
            list.add(str);
            return;
        }
        str+="->";
        if (root.left!=null)
            run(root.left, str);
        if (root.right!=null)
            run(root.right, str);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        run(root,"");
        return list;
    }
}
