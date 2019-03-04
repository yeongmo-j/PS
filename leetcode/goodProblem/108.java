"
[문제요약]
정렬된 배열이 들어오고,
이걸 balanced binary tree로 만들어라.
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following
height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

[해결방법]
루트에는 중간값이 들어오고, 왼쪽은 그 왼쪽에있는걸로 재귀,
오른쪽은 그 오른쪽에 있는거중 재귀 하면 된다.

Time complexity : O(N);
Space complexity : O(N);

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
    TreeNode make(int[]nums, int left, int right){
        if (left<=right){
            int mid = (left+right)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = make(nums, left,mid-1);
            node.right = make(nums,mid+1, right);
            return node;
        }
        return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return make(nums, 0, nums.length-1);
    }
}
