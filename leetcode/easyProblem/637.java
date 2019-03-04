'''
[문제요약]
트리의
각 레벨에 있는 원소들의 평균을 내라

[해결방법]
개수, 합을 각각 저장할 리스트 두개 만든다음에
레벨을 인자로 받는 bfs를 해서 마지막에 평균을 내준다.

Time complexity : O(N);
Space complexity : O(N);

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
    List<Integer> howmany;
    List<Long> sum;

    void bfs(TreeNode root, int level)
    {
        if (root!=null)
        {
            if (howmany.size()<=level)
            {
                howmany.add(1);
                sum.add((long)root.val);
            }
            else
            {
                howmany.add(level,howmany.get(level)+1);
                howmany.remove(level+1);
                sum.add(level,sum.get(level)+(long)root.val);
                sum.remove(level+1);
            }
            bfs(root.left,level+1);
            bfs(root.right,level+1);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        howmany = new LinkedList<Integer>();
        sum = new LinkedList<Long>();
        bfs(root,0);
        int size = howmany.size();
        List<Double> result = new ArrayList<Double>();
        for (int i=0; i<size ; i++)
            result.add((double)sum.get(i)/howmany.get(i));
        return result;
    }
}
