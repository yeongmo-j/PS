'''
[문제요약]
트리 2개 주어지고,
트리의 리프노드들의 왼쪽부터 오른쪽가지 순서가 같은지?

[해결방법]
dfs로 리프 찾아서 각각 리스트에 저장한뒤에 같은지 확인

Time complexity : O(N)여기서 N은 둘중에 더 큰 트리의 원소의 개수
Space complexity : O(N);

[추가]
dfs의 형태 잘 알아 둘것!!!!!!!!
if (node != null) {
    if (node.left == null && node.right == null)
        leafValues.add(node.val);
    dfs(node.left, leafValues);
    dfs(node.right, leafValues);
}
그리고 List<Integer>은 equals를 오버라이딩 해 놨다.
= Integer도 오버라이딩 되어 있다!!
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

    void leafvalue(List<Integer> list, TreeNode root)
    {
        if (root.left==null && root.right==null)
        {
            list.add(root.val);
            return;
        }
        if (root.left!=null)
            leafvalue(list,root.left);
        if (root.right!=null)
            leafvalue(list,root.right);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        leafvalue(list1,root1);
        leafvalue(list2,root2);
        int len1 = list1.size();
        int len2 = list2.size();
        if (len1!=len2)
            return false;
        for (int i=0 ; i<len1 ; i++)
            if ((int)(list1.get(i))!=(int)(list2.get(i)))
                return false;
        return true;
    }
}
