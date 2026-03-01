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
    public ListNode rotateRight(ListNode head, int k) {

        //Edge case
        if(head == null || head.next == null || k == 0) return head;

        //First find the length of the given Node list
        int len = 0;
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
            len += 1;
            prevNode = temp;
            temp = temp.next;
        }
        k = k%len;
        if(len == k || k == 0) return head;

        int dist = len - k;
        int cnt = 0;
        temp = head;

        while(temp != null) {
            cnt += 1;
            if(cnt == dist) {
                ListNode nextNode = temp.next;
                temp.next = null;
                prevNode.next = head;
                return nextNode;
            }

            temp = temp.next;
        }

        return head;
        
    }
}