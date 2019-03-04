"
[문제요약]
tilt는 오른쪽서브트리 총합과 왼쪽서브트리 총합의 차의 절대값이다.
트리의 모든 노드에 대해, tilt값의 합을 구하여라.

[해결방법]
resursion 이용.

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
    int tilt;
    int tiltMethod(TreeNode root){
        if (root==null)
            return 0;
        int leftSum = tiltMethod(root.left);
        int rightSum = tiltMethod(root.right);
        tilt += Math.abs(leftSum-rightSum);
        return root.val + leftSum + rightSum;
    }
    public int findTilt(TreeNode root) {
        tiltMethod(root);
        return tilt;
    }
}
