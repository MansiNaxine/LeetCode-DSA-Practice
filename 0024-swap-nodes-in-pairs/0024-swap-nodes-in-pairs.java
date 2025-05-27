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
        
        //we can do it by using recursion
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode next = temp.next;
        ListNode nextPart = next.next;
        next.next = temp;
        temp.next = swapPairs(nextPart);

        return next;

    }
}