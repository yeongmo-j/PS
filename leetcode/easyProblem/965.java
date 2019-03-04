'''
[문제요약]
바이너리트리에서 노드 값들이 다 같은값들을 갖고 있는지?

[해결방법]
inorder traversal 해서 다 같은지 판별해줬다.
일단 인자로 루트의 값(int)과 result결과값 을 넣어주고
하나라도 다른게 나오면 result를 false로 바꿔준 뒤 retrun 해줬다.

result가 boolean으로 자료형을 가져야 하는데, pass by value가 되니까
새로 클래스를 하나 만들어줬다.

Time complexity : O(N);
Space complexity : O(N);

[추가]
자바 pass by value vs reference 공부하기.
dfs로 원소 하나하나 리스트에 넣어준다음에
그거 다시 꺼내서 리스트 첫번째원소랑 다 비교해주는 방법도 사이트에 있는데
그거보단 이게 더 좋은거 같다.
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
class Bool
{
    boolean bool;
    Bool(boolean bool)
    {
        this.bool = bool;
    }
}

class Solution {

    public void inorder(TreeNode root, int i, Bool result)
    {
        if (root!=null)
        {
            inorder(root.left, i, result);
            if (root.val != i)
            {
                result.bool = false;
                return;
            }
            inorder(root.right, i, result);
        }
    }

    public boolean isUnivalTree(TreeNode root)
    {
        Bool result = new Bool(true);
        int value = root.val;
        inorder(root, value, result);
        if (result.bool==true)
            return true;
        else
            return false;
    }
}
