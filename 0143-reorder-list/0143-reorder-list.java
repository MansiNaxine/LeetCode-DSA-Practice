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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;
        //get the middle element
        ListNode middle = getMiddleElement(head);
        ListNode nextPart = middle.next;
        middle.next = null;
        //reverse the next part
        nextPart = reverseList(nextPart);
        //add accordingly
        int index = 0;
        ListNode i = head;
        ListNode j = nextPart;

        ListNode aH = null;
        ListNode aT = null;

        while(i != null && j != null) {
            if(index%2 == 0) {
                if(aH == null) {
                    aH = i;
                    aT = i;
                } else {
                    aT.next = i;
                    aT = aT.next;
                }
                i = i.next;
            } else {
                if(aH == null && aT == null) {
                    aH = j;
                    aT = j;
                } else {
                    aT.next = j;
                    aT = aT.next;
                }
                j = j.next;
            }

            index++;
        }

        if(i != null) {
            aT.next = i;
            aT = aT.next;
        }

        if(j != null) {
            aT.next = j;
            aT = aT.next;
        }


        head = aH;
        
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