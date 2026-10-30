class MinStack {

     Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(stack.isEmpty()) min = Math.min(Integer.MAX_VALUE, val);
        else min = Math.min(min, val);

        stack.add(val);
    }

    public void pop() {
        stack.pop();
        if(!stack.contains(min) && !stack.isEmpty()) {
            min = Integer.MAX_VALUE;
            for(int num : stack) {
                min = Math.min(num, min);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */