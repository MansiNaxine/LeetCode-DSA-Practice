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

        //first calculating the lnegth;
        // int count = 1;
        // ListNode temp = head;
        // while(temp.next != null) {
        //     temp = temp.next;
        //     count++;
        // }

        // int middle = count/2;
        // //Always middle element in Nodes list will be middle + 1
        // int countResult = 1;
        // temp = head;
        // while(countResult != middle + 1) {
        //     temp = temp.next;
        //     countResult++;
        // }


        //optimized approach
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        

        //return temp;
        return slow;
        
    }
}