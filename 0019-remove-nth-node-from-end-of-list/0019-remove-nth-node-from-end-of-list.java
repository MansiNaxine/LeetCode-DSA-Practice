/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head;
        ListNode fast = head;

        //we are moving fast pointer to reach at nth node to start traversing
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode prev = null;

        //now slow and fast pointer will move and slow pointer will move at nth node which we want to remove
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;

        
    }
}