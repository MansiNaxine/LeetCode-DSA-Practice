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
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;

        //to save the next part
        ListNode nextPart = next.next;

        next.next = head;
        head.next = swapPairs(nextPart);

        return next;


    }
}