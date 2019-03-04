'''
[문제요약]
이진트리 주어지고 그걸 inorder한 결과를 가지고 오른쪽 편향된 새로운 트리를 리턴해라
즉 트리에서 제일 왼쪽 아래 있는게 새로운 트리에선 루트가 된다.

[해결방법]

Time complexity : O(N);
Space complexity : O(N);

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
class BinTree
{
    TreeNode root;
    TreeNode lastNode;
    void insert(TreeNode node)
    {
        TreeNode temp = new TreeNode(node.val);
        if (root==null)
        {
            root=lastNode=temp;
            temp.left=null;
            temp.right=null;
        }
        else
        {
            lastNode.right=temp;
            lastNode = temp;
            temp.left=null;
            temp.right=null;
        }
    }
}

class Solution {
    BinTree tree;
    void inorder(TreeNode root)
    {
        if (root!=null)
        {
            inorder(root.left);
            tree.insert(root);
            inorder(root.right);
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        tree = new BinTree();
        inorder(root);
        return tree.root;
    }
}
