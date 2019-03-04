'''
[문제요약]
연결 리스트가 있고,
그 중간에 있는 한 노드에만 접근 권한이 주어졌다.
이때, 그 노드를 삭제하는 방법은??
(꼬리 아님)
헤드도 안주어지고, 그냥 그 노드만 하나 주어짐.
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
이렇게 결과를 만들어야 함.


[해결방법]
몰라서 해답봄...

Time Complexity = O(1);
Space Complecity = O(1);

[추가]
@@@@@@@@@@@@@@@@@@@@@@@@@
4->5->1->9에서
5를 없애려면,
5에다 1을 복사하고
거기서 바로 9로 연결해주면 된다....

진짜로 천재 혹은 바보같은 문제...
'''
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
