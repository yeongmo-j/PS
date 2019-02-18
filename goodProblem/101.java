"
[문제요약]
트리가 두개 주어지고,
두 트리가 대칭이니?
대칭이란, 원래 트리의 루트!! 를 중심으로 자식 노드들이 양쪽으로 데칼코마니니?
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

[해결방법]
일단 해본 방법은 BFS해보면서 각 원소들 리스트로 만들어서 해줬다.
그런데 공백도 처리해주기 위해 공백도 다 리스트에 추가해줬음.
그러다 보니 공백의 공백도 다 공간을 차지하게 됨... (리프노드들은 2^h개가 되버림)
결국 시간 초과 났음. 이 방법으로는 안된다.

그래서 솔루션 봤음.

    1
   / \
  2   2
   \   \
   3    3
여기서 2를 주목해보면,
왼쪽 2(a)의 왼쪽노드와 오른쪽 2(b)의 오른쪽 노드가 대칭이 되어야 한다.
또, a의 오른쪽 노드와, b의 왼쪽노드가 대칭이 되어야 한다.
또 a와 b의 값은 같아야 한다.
이런식으로 재귀가 가능하다1!!!!!!!!

Time complexity : O(N) 각 노드를 두번씩 확인하게 됨.
Space complexity : O(lgN);

[추가]
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
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }

    boolean symmetric(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null)
            return true;
        if (root1==null || root2==null)
            return false;
        return (root1.val==root2.val) && symmetric(root1.right, root2.left)
            && symmetric(root1.left, root2.right);
    }
}
