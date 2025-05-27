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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode eH = null;
        ListNode eT = null;

        ListNode oH = null;
        ListNode oT = null;

        int index = 1;
        ListNode temp = head;

        while(temp != null) {
            if(index%2 == 0) {
                if(eH == null) {
                    eH = temp;
                    eT = temp;
                } else {
                    eT.next = temp;
                    eT = temp;
                }
            } else {
                 if(oH == null) {
                    oH = temp;
                    oT = temp;
                } else {
                    oT.next = temp;
                    oT = temp;
                }
            }

            temp = temp.next;
            index++;
        }

        eT.next = null;
        oT.next = eH;

        return oH;
    }
}