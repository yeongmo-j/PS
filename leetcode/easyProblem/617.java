'''
[문제요약]
트리 두개 주어지고, 두개를 합치는데
셀로판지 두개 겹친것처럼 합친다.
노드가 같은위치에 둘다 존재하면 키가 그 두 트리 키의 합으로 바뀌고,
아니면 둘중에 존재하는 노드로 하면 된다.

[해결방법]
재귀

Time complexity : O(max(N,M))N,M은 두 트리의 노드 수
Space complexity : O(max(lgN,lgM))

[추가]
만약 t1이 null이면 t2를 return 해주면 된다.(t2도 null이라면 어차피 null이 되버림.)
코드가 훨씬 줄어든다.
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode temp;
        if (t1!=null && t2!=null)
        {
            temp = new TreeNode(t1.val+t2.val);
            temp.left = mergeTrees(t1.left, t2.left);
            temp.right = mergeTrees(t1.right, t2.right);
            return temp;
        }
        if (t1==null && t2==null)
            return null;
        if (t1!=null)
            return t1;
        else
            return t2;
    }
}
