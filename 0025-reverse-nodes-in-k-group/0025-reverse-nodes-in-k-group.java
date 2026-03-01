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
        
        int cnt = 0;
        ListNode temp = head;
        ListNode dummynode = new ListNode(-1);
        ListNode res = dummynode;
        ListNode reverseHead = null;
        ListNode tail = null;
        ListNode nextNode = null;

        while(temp != null) {
            cnt += 1;
            if(cnt == 1) tail = temp;
            if(cnt == k) {
                nextNode = temp.next;
                if(temp != null) temp.next = null;
                reverseHead = getReverseHead(tail);

                    if(dummynode.next == null) {
                        res.next = reverseHead;
                    } else {
                        res.next = reverseHead;
                    }
                        res = tail;
                        temp = nextNode;
            }

            
            if (cnt < k){
                temp = temp.next;
            }
            
            if(temp == null && cnt < k) {
                res.next = tail;
                break;
            } 

            if(cnt == k) cnt = 0;

        }

        return dummynode.next;
        
    }

    public ListNode getReverseHead(ListNode head) {

        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(temp != null) {
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }

        return prevNode;
    }
}