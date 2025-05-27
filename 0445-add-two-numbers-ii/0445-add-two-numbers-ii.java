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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode i = l1;
        ListNode j = l2;

        ListNode aH = null;
        ListNode aT = null;
        int carry = 0;

        while(i != null && j != null) {
            int sum = i.val + j.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            i = i.next;
            j = j.next;
        }

        while(i != null) {
            int sum = i.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            i = i.next;
        }

        while(j != null) {
            int sum = j.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            j = j.next;
        }

        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            aT.next = newNode;
            aT = newNode;
        }

        return reverseList(aH);
        
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


}