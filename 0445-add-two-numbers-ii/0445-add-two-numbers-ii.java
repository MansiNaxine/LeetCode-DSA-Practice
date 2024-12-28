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

    //reverseFunction
    public ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null) {
                next = next.next;
            }
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode i = l1;
        ListNode j = l2;

        int carry = 0;

        ListNode aH = null;
        ListNode aT = null;

        while ( i != null && j != null) {

            int sum = i.val + j.val + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);

            if (aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            i = i.next;
            j = j.next;

        }

        while (i != null) {

            int sum = i.val + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);

            if (aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            i = i.next;
        }

        while (j != null) {
            int sum = j.val + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);

            if (aH == null && aT == null) {
                aH = newNode;
                aT = newNode;
            } else {
                aT.next = newNode;
                aT = newNode;
            }

            j = j.next;
        }

        //take a case where both lists are like below
        //l1 -> 9 9 9
        //l2 -> 9 9 9
        //at last there will carry with 1

        if (carry > 0) {

            ListNode newNode = new ListNode(carry);
            aT.next = newNode;
            aT = newNode;
        }

        aH = reverse(aH);

        return aH;
    }
}