"
[문제요약]
트리 레벨별로 키의 값을 묶어서 리스트<리스트<Integer>>의 형태로 리턴.
역순으로 되고, 왼쪽부터 (리프노드의 리스트가 제일 처음으로 오게, 왼쪽부터)

[해결방법]
큐를 이용해 레벨오더 탐색을 하였고,
레벨을 기록하기 위해 ,노드와 레벨로 묶은 클래스를 하나 더 추가해주었다.
큐에 넣을 때, 레벨도 함께 기록하였다.

또한 레벨이 전에 있던 레벨과 다를 때마다, 리스트 안에 새로운 리스트를 만들어 주었다.

Time complexity : O(N);
Space complexity : O(1);

[추가]
큐에 집어 넣을 때, 새로운 클래스를 만들지 말고
레벨 별로 분류 할 수가 있다.
어떻게 하냐?
루프를 돌릴 때, 큐가 비어있지 않으면,
 큐의 사이즈를 기록해둔다 <- 이 사이즈가 그 레벨의 현재 값들이다.
 이제 그 @@사이즈 만큼만@@ 큐에서 빼서 리스트에 추가 하고, 자식들을 큐에 추가한다.
 그렇게 되면 딱 while루프가 시작 되기 전 큐에 있던 노드들(같은레벨) 만큼만 탐색이 가능하다.

 public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(q.size()>0){
        List<Integer> list = new ArrayList<>();
        int size = q.size();
        for(int i=0; i<size; i++){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        result.add(0,list);
    }
    return result;

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

class TreeAndLevel{
    TreeNode node;
    int level;
    TreeAndLevel(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeAndLevel> queue = new LinkedList<TreeAndLevel>();
        if (root==null)
            return list;
        queue.offer(new TreeAndLevel(root, 0));
        int nowLevel = -1;
        while(!queue.isEmpty()){
            TreeAndLevel temp = queue.remove();
            if (temp.level!=nowLevel){
                nowLevel = temp.level;
                list.add(0, new LinkedList<Integer>());
                list.get(0).add(temp.node.val);
            }
            else{
                list.get(0).add(temp.node.val);
            }
            if (temp.node.left!=null)
                queue.offer(new TreeAndLevel(temp.node.left, temp.level+1));
            if (temp.node.right!=null)
                queue.offer(new TreeAndLevel(temp.node.right, temp.level+1));
        }
        return list;
    }
}
