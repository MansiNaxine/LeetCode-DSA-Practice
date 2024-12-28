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

        if(head == null) {
            return head;
        }

            ListNode oH = null;
            ListNode oT = null;
            ListNode eH = null;
            ListNode eT = null;

            ListNode temp = head;
            int index = 1;

            while (temp != null) {
                
                if (index % 2 == 0) {

                    if(eH == null && eT == null) {
                        eH = temp;
                        eT = temp;
                    } else {
                        eT.next = temp;
                        eT = temp;
                    }

                } else {

                    if(oH == null && oT == null) {
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

            oT.next = eH;

            if(eT != null) {
                eT.next = null;
            }

        return oH;
    }
}