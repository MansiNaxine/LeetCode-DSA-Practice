/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        //if cycle is present then start the fast index from head position and keep the speed same as slow , at some point both slow and fast pointer will reach at the same position.
        
        if(isCycle) {
            fast = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
        
    }
}