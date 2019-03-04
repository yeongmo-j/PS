'''
[문제요약]
트리 각 레벨에서 제일 높은 값 찾기.

[해결방법]
bfs로 레벨을 인자로 받는다.

Time complexity : O(N);
Space complexity : O(lgN);

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
class Solution {
    Map<Integer,Integer> map;
    int max;

    void bfs(TreeNode root, int level)
    {
        if (root!=null){
            if (level>max)
                max=level;
            if (map.containsKey(level)){
                if (map.get(level)<root.val)
                    map.replace(level, root.val);
            }
            else
                map.put(level, root.val);
            bfs(root.left, level+1);
            bfs(root.right, level+1);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();
        max=-1;
        bfs(root, 0);
        if (max>=0)
            for (int i=0 ; i<=max ; i++)
                list.add(map.get(i));
        return list;
    }
}
