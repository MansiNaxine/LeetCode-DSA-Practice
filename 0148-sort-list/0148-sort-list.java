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

        if(head==null || head.next==null){
            return head;
        }

        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);


        return merge(left,right);
        
        
    }

    //funtion to merge to lists
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummyHead=new ListNode();
        ListNode temp=dummyHead;

        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }

        temp.next=(left!=null)?left:right;

        return dummyHead.next;
    }

    //function to get middle element
    public ListNode getMid(ListNode head){
        ListNode temp=null;

        while(head!=null && head.next!=null){
            temp=(temp==null)?head:temp.next;
            head=head.next.next;
            
        }

        ListNode mid=temp.next;
            temp.next=null;
            
        return mid;
    }
}