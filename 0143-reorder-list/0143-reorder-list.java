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
        

        if(head==null || head.next==null){
            return;
        }

        ListNode mid=getMid(head);
        ListNode end=reverseList(mid);
        ListNode start=head;

        while(start!=null && end!=null){
            ListNode temp=start.next;
            start.next=end;
            start=temp;

            temp=end.next;
            end.next=start;
            end=temp;


            }

            if(start!=null){
                start.next=null;
            }
        

        
    }

    public ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }

        ListNode  prev=null;
        ListNode  current=head;
        ListNode  next=current.next;

        while(current!=null){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null){
                next=next.next;
            }
        }

        return prev;
    }

    public ListNode getMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        return slow;
    }
}