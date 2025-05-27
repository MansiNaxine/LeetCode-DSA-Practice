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
    public boolean isPalindrome(ListNode head) {

        //first get the middle element in even case we need first middle element
        //in odd case we will get the correct one
        ListNode middle = getMiddleElement(head);
        ListNode nextPart = middle.next;
        middle.next = null;

        //we have to reverse the nextPart
        nextPart = reverseList(nextPart);
        ListNode i = head;
        ListNode j = nextPart;

        while(i != null && j != null) {
            if(i.val != j.val) {
                return false;
            }

            i = i.next;
            j = j.next;
        }

        return true;
        
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    public ListNode getMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}