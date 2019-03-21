"
[문제요약]
정렬된 리스트가 하나 입력으로 들어올 떄,
중복되는거 다 제거하고,
한번씩만 등장하게 리스트를 바꿔서 리턴해라

[해결방법]
지금꺼 저장해두고,
자기와 다를떄까지 리스트를 다음으로 계속 이동시킨다.
달라지면, 저장해둔 지금과 그 다음으로 이동한거를 연결시켜주고,
지금을 그걸로 바꿔준다.

Time complexity : O(N)
Space complexity : O(N)

[추가]

"
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headCopy = head;
        while(head!=null){
            int nowVal = head.val;
            ListNode next = head;
            while (next!=null && next.val==nowVal){
                next = next.next;
            }
            head.next = next;
            head = next;
        }
        return headCopy;
    }
}
