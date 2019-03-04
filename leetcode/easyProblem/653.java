'''
[문제요약]
BST주어지고 숫자 k가 주어지면,
트리의 값들 2개 합해서 k 만들수 있으면 true 없으면 false

[해결방법]
traversal 해서 map의 원소로 집어넣는다.
만약 k-val이 키로 없으면 (val,k-val)로 맵에 집어넣는다
k-val이 키로 있으면 true를 반환.
키가 없었을 경우에,
 왼쪽과 오른쪽자식으로 이동하여 재귀하는데, 둘중에 하나면 true여도 true 반환.

Time Complexity = O(N);
Space Complecity = O(N); ->맵때문에

[추가]
Map 말고 set으로 해도 된다..
만약 k-val이 있으면 true
없으면 val 집어넣기..

또한 왼쪽자식 오른쪽자식 재귀도 깔끔하게 가능함
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
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
    Map<Integer, Integer> map;

    boolean bfs(TreeNode root, int k){
        if (root!=null){
            if (map.containsKey(k-root.val))
                return true;
            else
                map.put(root.val, k-root.val);
            if (root.left!=null)
                if (bfs(root.left,k))
                    return true;
            if (root.right!=null)
                if (bfs(root.right,k))
                    return true;
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<Integer, Integer>();
        return bfs(root, k);
    }
}
