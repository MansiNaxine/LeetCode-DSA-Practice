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
    public ListNode sortList(ListNode head) {

        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(arr);
        temp = head;
        int index = 0;
        while(temp != null) {
            temp.val = arr.get(index);
            index++;
            temp = temp.next;
        }

        return head;
        
    }
}