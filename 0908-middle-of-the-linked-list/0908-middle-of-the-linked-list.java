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
    public ListNode middleNode(ListNode head) {
        
        // int length = 0;
        // ListNode temp = head;
        // while(temp != null){
        //     temp = temp.next;
        //     length++;
        // }

        // int mid = length/2;
        // temp = head;
        // while(mid > 0){
        //     temp = temp.next;
        //     mid--;
        // }

        // return temp;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}