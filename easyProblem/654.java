'''
[문제요약]
maximum binary tree 만들기.
배열이 주어지면 그 배열의 위치로 만든다.
배열중에 제일 큰게 루트고
그 배열의 원소 왼쪽에 있는거가 왼쪽 서브트리, 배열의 원소 오른쪽에 있는것들로 오른쪽 서브트리 만든다.

[해결방법]
재귀로 만들어준다.

Time complexity : O(n^2) 이미 정렬되었을 경우. 편향 트리가 생기므로 n^2이다. 평균은 nlogn임
Space complexity : O(n) : 원소의 수 만큼.

[추가]
바이너리 트리 complexity 계산방법 꼭 숙지해 두기!!!
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
    TreeNode makeBinaryTree(int[]nums, int p, int q){
        if (p>q)
            return null;
        TreeNode node;
        int max = p;
        for (int i=p+1 ; i<=q ; i++)
        {
            if (nums[i]>nums[max])
                max = i;
        }
        node = new TreeNode(nums[max]);
        node.left = makeBinaryTree(nums,p,max-1);
        node.right = makeBinaryTree(nums,max+1, q);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = makeBinaryTree(nums, 0, nums.length-1);
        return root;
    }
}
