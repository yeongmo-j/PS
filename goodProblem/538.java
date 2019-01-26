"
[문제요약]
BST가 주어지고,
각 노드들을 수정하는데,
자기보다 큰 키의 합을 거기다 더한다.
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13

[해결방법]
일단 inorder로 리스트에 하나씩 추가했다. (정렬됨)
그러고 그 리스트를 뒤에서부터 탐색해서 합해가며,
키가 몇일때 뒤의 합이 몇인지를 map에다 저장한 뒤,
다시 traversal 하며, 매핑되는 값을 넣어주었다.
!!!매우느림!!!

Time complexity : O(N);
Space complexity : O(N)

[추가]
@@@@@@좋은방법@@@@@@@
탐색 한번으로 다 끝낼 수 있다.

class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if (root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
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
    List<Integer> list;
    Map<Integer, Integer> map;

    void inorder(TreeNode root){
        if (root!=null){
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
    void modify(TreeNode root){
        if (root!=null){
            modify(root.left);
            root.val += map.get(root.val);
            modify(root.right);
        }
    }
    public TreeNode convertBST(TreeNode root) {
        list = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
        inorder(root);
        int sum=0;
        int before=500000;
        int now;
        for (int i= list.size()-1 ; i>=0 ; i--){
            now = list.get(i);
            if (now<before){
                map.put(now, sum);
                sum+=now;
                before=now;
            }
        }
        modify(root);
        return root;
    }
}
