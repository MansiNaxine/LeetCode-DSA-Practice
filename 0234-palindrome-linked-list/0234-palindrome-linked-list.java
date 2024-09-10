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
    public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode headSecond=reverseList(mid);
        ListNode reverseBack=headSecond;

        //compare login will be here
        while(head!=null && headSecond!=null){
            if(head.val!=headSecond.val){
                break;
            }else{
                head=head.next;
                headSecond=headSecond.next;
            }
        }

        

        reverseList(reverseBack);

        if(head==null || headSecond==null){
            return true;
        }


        return false;

        
    }

    public ListNode reverseList(ListNode head){

        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode current=head;
        ListNode next=current.next;

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