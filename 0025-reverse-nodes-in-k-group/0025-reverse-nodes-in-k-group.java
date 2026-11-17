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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode firstHead = null;
        ListNode reverseHead = null;
        ListNode temp = head;
        ListNode changingHead = temp;
        ListNode nextHead = null;
        ListNode finalHead = null;
        int cnt = 0;

        while(temp != null) {
            cnt += 1;
            nextHead = null;
            if(cnt == k) {
                cnt = 0;
                nextHead = temp.next;
                temp.next = null;
                reverseHead = reverseList(changingHead);
                if(finalHead == null) finalHead = reverseHead;
                if(firstHead != null) firstHead.next = reverseHead;
                firstHead = changingHead;
                changingHead = nextHead;
            }
            temp = nextHead != null ? nextHead : temp.next;
        }

        if(cnt < k && firstHead != null) firstHead.next = changingHead;

        return finalHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            ListNode nH = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nH;
        }

        return prev;

    }
}