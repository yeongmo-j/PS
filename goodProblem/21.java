"
[문제요약]
정렬된 연결리스트 2개가 주어지고, 2개를 merge해서 정렬된 리스트 하나로 만들어라.

[해결방법]
맨앞에 더미노드 하나 만들어주고,
그 뒤로 하나씩 연결시켰다.

Time complexity : O(N); N은 두 리스트 노드들의 크기.
Space complexity : O(1);

[추가]
재귀적으로 만들 수 있었다.
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1); //dummy
        ListNode result = first;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                result.next = l1;
                result = l1;
                l1 = l1.next;
            }
            else {
                result.next = l2;
                result = l2;
                l2 = l2.next;
            }
        }
        if (l1!=null)
            result.next = l1;
        if (l2!=null)
            result.next = l2;
        return first.next;
    }
}
