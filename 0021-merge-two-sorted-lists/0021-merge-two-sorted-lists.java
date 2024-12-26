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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // if (list1 == null) return list2;
        // if (list2 == null) return list1;

        // if (list1.val < list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // } else {
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if(l1 != null) {
            curr.next = l1;
        }

        if(l2 != null) {
            curr.next = l2;
        }

        return temp.next;
        
    }
}