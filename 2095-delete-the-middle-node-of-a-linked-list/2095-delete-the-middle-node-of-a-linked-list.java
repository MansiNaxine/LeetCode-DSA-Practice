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
    public ListNode deleteMiddle(ListNode head) {

        //Edge case
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        //first find the middle element
        int cnt = 0;

        while(fast != null && fast.next != null) {
            cnt += 1;
            slow = slow.next;
            fast = fast.next.next;
        }

        int k = 0;
        ListNode temp = head;
        ListNode newHead = temp;
        while(temp != null && temp.next != null) {
            k += 1;
            if(k == cnt) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return newHead;
    }
}