"
[문제요약]
트리가 주어지고, 두 노드들을 골랐을 때, 그 서로까지의 경로의 길이가 제일 긴게 몇이니?
루트를 지날수도, 안지날수도 있다.

[해결방법]
왼쪽, 오른쪽 서브트리의 깊이를 센 다음에, 둘을 더한이 경로의 값이 된다.
깊이를 세는게 관건.

Time complexity : O(N);
Space complexity : O(N)

[추가]
@@@@@좋은방법@@@@@@
내가한 방법은 각 레벨을 인자로 넘기는 방법인데,
그냥 깊이로 세자.
depth는
왼쪽서브트리,오른쪽 서브트리의 깊이중 더 깊은거 +1이다.

public int depth(TreeNode node) {
    if (node == null) return 0;
    int L = depth(node.left);
    int R = depth(node.right);
    ans = Math.max(ans, L+R+1);
    return Math.max(L, R) + 1;
}

"
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
    int max= 0;
    int height(TreeNode root, int i){
        //i번째 레벨이라는 뜻.
        if (root==null)
            return i-1;
        int left = height(root.left, i+1);
        int right = height(root.right, i+1);
        if (left-i+right-i>max)
            max = left-i+right-i;
        return Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root,0);
        return max;
    }
}
