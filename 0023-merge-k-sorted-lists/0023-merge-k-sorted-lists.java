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
    public ListNode mergeKLists(ListNode[] lists) {

        int minValue = Integer.MAX_VALUE;
        int index = -1;

        for(int i =0 ; i < lists.length; i++) {
            if(lists[i] != null && lists[i].val <= minValue) {
                minValue = lists[i].val ;
                index = i;
            }
        }

        if(index == -1) {
            return null;
        }

        //for the starting Node
        ListNode startingNode = lists[index];
        lists[index] = lists[index].next;
        startingNode.next = mergeKLists(lists);

        return startingNode;
        
    }
}