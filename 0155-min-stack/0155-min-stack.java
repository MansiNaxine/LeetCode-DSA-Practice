class MinStack {

    Stack<LinkedList<Integer>> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {

        if(st.isEmpty()) min = Math.min(Integer.MAX_VALUE, val);
        else min = Math.min(st.peek().get(1), val);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(val);
        list.add(min);

        st.push(list);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().get(0);
    }
    
    public int getMin() {
        return st.peek().get(1);
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