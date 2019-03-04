'''
[문제요약]
binary tree가 2개 주어지고, 그 서브트리가 같거나, 뒤집혀 있으면 됨
전체가 아니라 일부분만 뒤집어있어도 같은거임!(서브트리 뒤집는걸 몇번 해서 두개가 같아지면 됨)

[해결방법]
두 트리가 같은지 판별하는 메소드에서
왼쪽서브트리==왼쪽서브트리&&오른쪽서브트리==오른쪽서브트리 ||
왼쪽서브트리==오른쪽서브트리&&오른쪽서브트리==왼쪽서브트리
인지 왁인하자

Time complexity : O(n) 왼쪽 서브트리와 오른쪽 서브트리를 두번씩 확인해야 한다
Space complexity : O(lgn) : 스택이 트리 높이만큼 쌓인다

[추가]
and or 여러개 겹쳐쓰는거 너무 어렵다. 연습할 것.

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
    boolean isEqual(TreeNode root1, TreeNode root2)
    {
        return ((root1==null&&root2==null) ||
        ((root1!=null&&root2!=null)&&
        (root1.val==root2.val)&&
        ((isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right))||
        (isEqual(root1.left,root2.right)&&isEqual(root1.right,root2.left)))));
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isEqual(root1, root2);
    }
}
