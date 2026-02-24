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
        //Edge case
        if(head == null || head.next == null) return null;
        ListNode temp1 = head;
        ListNode newHead = reverseList(temp1);
        int cnt = 0;
        if(n == 1) {
            newHead = newHead.next;
            cnt = 1;
        }
        ListNode temp = newHead;
        

        while(temp != null && temp.next != null) {
            cnt += 1;
            if(cnt > n - 1) break;
            if(cnt == n - 1) {
                temp.next = temp.next.next;
            }
            temp = temp.next ;
        }

        head = reverseList(newHead);
        return head;

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