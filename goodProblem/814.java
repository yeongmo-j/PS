'''
[문제요약]
바이너리 트리에서 왼쪽 서브트리 원소가 다 0이면 삭제,
오른쪽 서브트리 원소가 다 0이면 삭제

[해결방법]
재귀를 이용해 풀었다.
경계조건 주의

Time complexity : O(N) N은 트리의 원소의 개수
Space complexity : O(lgN) 스택이 높이만큼 쌓인다.

[추가]
기준을 자기가 기준이 되야 한다.
왼쪽 재귀->끊어주기
오른쪽 재귀->끊어주기
자식들 없고 자기가 0이면 true 리턴
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
    boolean deleteZero(TreeNode node)
    {
        if (node==null) return false;
        if (deleteZero(node.left))
            node.left = null;
        if (deleteZero(node.right))
            node.right = null;
        if (node.val==0 && node.left==null && node.right==null)
            return true;
        else
            return false;
    }
    public TreeNode pruneTree(TreeNode root) {
        deleteZero(root);
        return root;
    }
}
