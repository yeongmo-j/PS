'''
[문제요약]
BST에서 키 찾기.

[해결방법]
BST 탐색

Time complexity : O(lgN);
Space complexity : O(lgN);

[추가]
'''
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root!=null)
        {
            if (root.val == val)
                return root;
            else if (root.val > val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
        return null;
    }
}
