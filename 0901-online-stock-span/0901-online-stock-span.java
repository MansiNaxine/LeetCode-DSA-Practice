class StockSpanner {

    ArrayList<Integer> list ;
    Stack<Integer> st ;
    ArrayList<Integer> answer ;

    public StockSpanner() {
        list = new ArrayList<>();
        st = new Stack<>();
        answer = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int i = list.size() - 1;

        while(!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
        }

        if (st.isEmpty()) answer.add(i - (-1));
        else answer.add(i - st.peek()) ;

        st.push(i);

        return answer.getLast();
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */