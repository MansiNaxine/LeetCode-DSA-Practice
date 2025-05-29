class MinStack {

    Stack stack;
    Stack miStack;
    int minValue;

    public MinStack() {
        stack = new Stack();
        miStack = new Stack();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            minValue = val;
        } else {
            minValue = Math.min((int)miStack.peek(), val);
        }

        stack.push(val);
        miStack.push(minValue);
           
    }
    
    public void pop() {
        stack.pop();
        miStack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return 0;
        } else {
            return (int)stack.peek();
        }
       
    }
    
    public int getMin() {
        // if(stack.isEmpty()) {
        //     return 0;
        // }
       return (int)miStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */