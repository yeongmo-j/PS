'''
[문제요약]
트리 최대깊이 구하기

[해결방법]

Time complexity : O(N);
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
    public int maxDepth(TreeNode root) {
        if (root!=null)
        {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (left>=right)
                return left+1;
            return right+1;
        }
        return 0;
    }
}
