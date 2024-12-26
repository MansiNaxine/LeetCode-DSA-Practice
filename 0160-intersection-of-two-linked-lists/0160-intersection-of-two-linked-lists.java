/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int getLength(ListNode head) {
        
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public ListNode giveTheEdge(ListNode head, int extra) {

        while(extra > 0){
            head = head.next;
            extra--;
        }

        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1 = getLength(headA);
        int len2 = getLength(headB);

        //we have to find starting point of both the linkedlists so that we can easily find the intersection point
        ListNode curA = headA;
        ListNode curB = headB;

        if(len1 > len2) {
            curA = giveTheEdge(headA, len1 - len2);
        } else {
            curB = giveTheEdge(headB, len2 - len1);
        }

        while(curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;

    }
}