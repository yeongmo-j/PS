'''
[문제요약]
linked list에서 중간 원소 찾기
(짝수개면 중간 2개 중 뒤에껄로 찾기)

[해결방법]
가운데 노드를 참조할 참조변수 하나 생성하고,
하나씩 넘어가며 개수를 측정한다.
만약 개수가 2n개가 되면, middle을 다음 노드로 바꿔준다
(개수가 두개 늘어나면, 중간 원소도 다음껄로 이동한다.)

Time complexity : O(N);
Space complexity : O(1);

[추가]

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
    public ListNode middleNode(ListNode head) {
        ListNode middle;
        int n = 1;
        middle = head;
        head = head.next;
        while(head!=null)
        {
            n++;
            if (n%2==0)
                middle= middle.next;
            head = head.next;
        }
        return middle;
    }
}
