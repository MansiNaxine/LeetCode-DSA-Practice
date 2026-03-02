/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        //first create copy nodes
        while(temp != null) {
            Node copyNode = new Node(temp.val);
            Node nextNode = temp.next;
            temp.next = copyNode;
            copyNode.next = nextNode;
            temp = temp.next.next;
        }

        

        //Now point the random pointers
        temp = head;
        while(temp != null) {
            Node randomPointer = temp.random;
            if(randomPointer == null) {
                temp.next.random = null;
            }
            else {
               temp.next.random = temp.random.next; 
            }
            temp = temp.next.next;
        }
        

        //point the next pointers
        temp = head;
        res.next = temp.next;
        res = res.next;

        while(temp != null && res != null) {
            Node nextNode = temp.next.next;
            temp.next = nextNode;
            temp = nextNode;
            if(temp != null ) {
                res.next = temp.next;
                res = res.next;
            }
        }

        return dummyNode.next;

    }
}