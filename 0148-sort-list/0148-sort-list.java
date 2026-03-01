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
        // return bruteForceApproach(head);

        return optimalApproach(head);
    }

    public ListNode optimalApproach(ListNode head) {

        //solving it by using merge sort
        //Base case
        if(head == null || head.next == null) return head;

        //We have to find middleNode
        ListNode middleNode = getMiddle(head);
        ListNode nextOfMiddle = middleNode.next;
        middleNode.next = null;

        ListNode leftNode = optimalApproach(head);
        ListNode rightNode = optimalApproach(nextOfMiddle);

        return merge(leftNode, rightNode);
        
    }

    public ListNode merge(ListNode list1,ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null && temp2 != null) {
            if(temp1.val < temp2.val) {
                res.next = temp1;
                res = temp1;
                temp1 = temp1.next;
            }
            else {
                res.next = temp2;
                res = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) res.next = temp1;

        if(temp2 != null) res.next = temp2;

        return dummyNode.next;

    }

    public ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode bruteForceApproach(ListNode head) {
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