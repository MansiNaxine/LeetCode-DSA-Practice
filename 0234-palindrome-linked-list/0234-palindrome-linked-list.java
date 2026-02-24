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

        //Optimal Spproach
        //1.Calculate the middle using fast and slow pointers
        //2. Reverse the second half
        //3.Compare the elements till half

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextHead = reverseList(slow);
        ListNode temp1 = head;
        ListNode temp2 = nextHead;

        while(temp1 != null && temp2!= null) {
            if(temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;

        
    }

    public ListNode reverseList(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        ListNode nextNode = null;

        while(temp != null) {
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}