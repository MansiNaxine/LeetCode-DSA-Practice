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
        
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode newNode = new ListNode();
        ListNode newHead = newNode;
        int sum = 0;

        while(temp1 != null && temp2 != null) {
            sum = temp1.val + temp2.val + carry;
            if(newNode == null) newNode.val = sum%10;
            else {
                ListNode currNode = new ListNode(sum%10);
                newNode.next = currNode;
                newNode = currNode;
            }
            carry = sum/10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null) {
            sum = temp1.val + carry;
            if(newNode == null) newNode.val = sum%10;
            else {
                ListNode currNode = new ListNode(sum%10);
                newNode.next = currNode;
                newNode = currNode;
            }
            carry = sum/10;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            sum = temp2.val + carry;
            if(newNode == null) newNode.val = sum%10;
            else {
                ListNode currNode = new ListNode(sum%10);
                newNode.next = currNode;
                newNode = currNode;
            }
            carry = sum/10;
            temp2 = temp2.next;
        }

        if(carry > 0) {
            ListNode currNode = new ListNode(carry);
            newNode.next = currNode;
        }

        return newHead.next;
    }
}