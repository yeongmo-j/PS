'''
[문제요약]
바이너리 트리에서 l이상 r이하의 값들 다 더하기

[해결방법]
inorder traversal 해주었다.

Time complexity : O(N);
Space complexity : O(lgN)시스템 스택에 쌓이는 개수는 현재 노드의 레벨만큼 쌓인다.

[추가]
구간 사이의 값들만 찾는거니까,
왼쪽자식 노드로 옮겨갈 때, l보다 크거나 같은지 확인한 뒤에 넘어가고
오른쪽자식 노드로 옮겨갈 때, r보다 작거나 같은지 확인해주면, 안넘어가도 된다!!

클래스 멤버로 sum 변수를 추가해줘서 전역변수 느낌으로 사용 가능.
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
    int sum;
    void inorder(TreeNode node, int L, int R)
    {
        if (node!=null)
        {
            inorder(node.left, L, R);
            if (node.val>=L && node.val<=R)
                sum+=node.val;
            inorder(node.right, L, R);
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        inorder(root, L, R);
        return sum;
    }
}
