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

        //first we have to calculate the count of nodes list
        int count = 1;
        ListNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
            count++;
        }

        int index = count - n + 1;
        int countResult = 1;
        temp = head;
        ListNode prev = head;

        while(countResult != index) {
            prev = temp;
            temp = temp.next;
            countResult++;
        }

        prev.next = temp.next;

        return count == n ? head.next : head;

        
    }
}