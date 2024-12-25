class Node {
    int val ;
    Node next ;

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {

    Node head;
    int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {

        if(index < 0 || index >= this.length){
            return -1;
        }

        if(index == 0 && this.head == null){
            return -1;
        }

        Node temp = this.head;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;

        this.head = newNode;
        this.length +=1;
    }
    
    public void addAtTail(int val) {
       
        if(this.head == null){
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = this.head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        this.length +=1;

    }
    
    public void addAtIndex(int index, int val) {
        
        if(index < 0 || index > this.length){
            return;
        }

        if(index == 0){
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = this.head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        this.length +=1;

    }

    public void deleteAtHead(int index){
        if(this.head != null){
            Node secondNode = this.head.next;
            this.head = secondNode;
        } else {
            this.head = null;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length){
            return;
        }

        if(index == 0){
            deleteAtHead(index);
            return;
        }
        Node temp = this.head;
        for(int i = 0 ; i < index  - 1 ; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        this.length -= 1;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */