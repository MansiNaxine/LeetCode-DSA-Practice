class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    int size;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        size = 0;
    }
    
    public void push(int x) {
        st1.push(x);
        size++;
    }
    
    public int pop() {
        int answer = -1;
        if(st1.isEmpty()) {
            return answer;
        } else {
            for(int i = 0; i < size - 1; i++) {
                st2.push(st1.pop());
            }
            answer = st1.pop();
            size--;
            for(int i = 0; i < size; i++) {
                st1.push(st2.pop());
            }
            
        } 

        return answer;
    }
    
    public int peek() {
        int answer = -1;
        if(st1.isEmpty()) {
            return answer;
        } else {
            for(int i = 0; i < size - 1; i++) {
                st2.push(st1.pop());
            }
            answer = st1.peek();
            for(int i = 0; i < size - 1; i++) {
                st1.push(st2.pop());
            }
            
        } 

        return answer;
    }
    
    public boolean empty() {
         return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */