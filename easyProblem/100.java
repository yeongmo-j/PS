"
[문제요약]
두 트리가 같니?

[해결방법]
재귀.

Time complexity : O(N);
Space complexity : O(N)

[추가]

"

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        return (p!=null && q!=null && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val==q.val);
    }
}
