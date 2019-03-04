'''
[문제요약]
트리에서, 제일 아래있는 레벨에서 가장 왼쪽에 있는 노드를 찾아라(완전이진 아님)

[해결방법]
bfs로 돈 다음에,
인자로 몇번째 레벨인지도 같이 받아서,
레벨이 제일 높으면, 제일 높은 레벨 갱신 한 뒤에, 값을 저장한다.
마지막에 저장된 값 리턴

Time complexity : O(N);
Space complexity : O(N);

[추가]
큐 이용해서 dfs로 도는데, 오른쪽부터 돌아도 됨.(이게 더 빠를듯)
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
    int maxlevel;
    int value;
    void inorder(TreeNode root,int level)
    {
        if (root!=null)
        {
            inorder(root.left, level+1);
            if (level>maxlevel)
            {
                maxlevel = level;
                value = root.val;
            }
            inorder(root.right, level+1);
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        maxlevel = -1;
        value = 0 ;
        inorder(root,0);
        return value;
    }
}
