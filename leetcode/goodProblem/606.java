'''
[문제요약]
트리를 preorder traversal 해서 문자열로 표현하기.
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"
쓸대없는 () -> 자식 없거나, 오른쪽자식 없을경우는 없앨 것.

[해결방법]
preorder 해서 종류별로 나눠서 재귀 생성해줬다.
둘다 자식 있을 경우(왼쪽)(오른쪽)
왼쪽만 있을경우 (왼쪽)
오른쪽만 있을경우 ()(오른쪽)

Time Complexity = O(N);
Space Complecity = O(lgN);

[추가]
이걸 아예 따로 메소드 빼서 멤버변수를 통해 처리하지 말고,
주어진 메소드 자체로 재귀 할 수 있음. 깔끔하게

public class Solution {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
}
이렇게

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
    String str;

    public void preorder(TreeNode t){
        if (t!=null){
            str+=t.val;
            if (t.left!=null || t.right!=null){
                if (t.left!=null){
                    str+="(";
                    preorder(t.left);
                    str+=")";
                }
                else
                    str+="()";
                if (t.right!=null){
                    str+="(";
                    preorder(t.right);
                    str+=")";
                }
            }
        }
    }
    public String tree2str(TreeNode t) {
        str="";
        preorder(t);
        return str;
    }
}
