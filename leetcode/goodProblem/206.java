'''
[문제요약]
리스트 반대로 돌리기
5->4->3->2->1->null
을
1->2->3->4->5->null
로 바꿔야 함.

[해결방법]
반복, 재귀 둘다 해봄.

Time Complexity = O(N);
Space Complecity = O(1); ->반복

O(N), O(N) ->재귀

[추가]
쉬운 문제지만 구현할때 생각해야할점이 있음.

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
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        ListNode next;
        while (head!=null){
            next = head.next;
            head.next=lastNode;
            lastNode=head;
            head = next;
        }
        return lastNode;
    }
}

class Solution {
    ListNode top;
    void run(ListNode head){
        if (head!=null){
            ListNode temp = head.next;
            head.next=top;
            top = head;
            run(temp);
        }
    }
    public ListNode reverseList(ListNode head) {
        top = null;
        run(head);
        return top;
    }
}
