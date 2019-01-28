"
[문제요약]
바이너리 트리에서 왼쪽 '리프'의 모든 합을 구하여라.

[해결방법]
재귀 이용.

Time complexity : O(N);
Space complexity : O(lgN)

[추가]
왼쪽 리프의 조건 확인 잘 하고 잘 구현 할 것.
더 쉽게 하는 방법도 있다.

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);

    return ans;
}
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

    int sumLeft(TreeNode root, int from){
        int sum=0;
        if (root!=null){
            if (root.left==null && root.right==null){
                if (from==1)
                    sum+=root.val;
            }
            sum+=sumLeft(root.left, 1);
            sum+=sumLeft(root.right, 2);
        }
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root,0);
    }
}
