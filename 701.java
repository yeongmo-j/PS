'''
[문제요약]
트리에 노드 추가하기

[해결방법]
위에서부터 value값을 비교해가며 아래로 내려간다음에, 리프에 다다르면 연결시켜준다.

Time complexity : O(lgN) 최대 높이만큼만 내려간다.
Space complexity : O(1) : 스택 사용하지 않고 반복문을 사용하므로

[추가]
다음 노드로 이동할 때, 코드가 약간 지저분해 지는데, 이걸 보완할 방법이?
(나는 다음 노드가 존재하는지 안하는지 확인한 뒤에, 다음 노드가 Null이면 그때 연결시켜줬다.)
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        node.left = null;
        node.right = null;
        TreeNode temp = root;
        if (root==null)
            return node;
        while (true){
            if (temp.val < val){
                if (temp.right==null){
                    temp.right = node;
                    break;
                }
                else
                    temp = temp.right;
            }
            else{
                if (temp.left == null){
                    temp.left = node;
                    break;
                }
                else
                    temp = temp.left;
            }
        }
        return root;
    }
}
