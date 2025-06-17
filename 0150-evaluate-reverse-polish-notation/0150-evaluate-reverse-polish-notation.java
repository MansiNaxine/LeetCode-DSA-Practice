class Solution {

    public boolean isOperator(String ch) {
        if(ch.equals("*") || ch.equals("+") || ch.equals("-")  || ch.equals("/") ) {
            return true;
        }

        return false;
    }
    public int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n; i++) {
            String a = tokens[i];
            if(isOperator(a) == false) {
                st.push(Integer.parseInt(a));
            } else {
                int A = st.pop();
                int B = st.pop();
                int result = 0;
                if(a.equals("+")) result = (B + A);
                if(a.equals("*")) result = (B * A);
                if(a.equals("-")) result = (B - A);
                if(a.equals("/")) result = (B / A);


                st.push(result);
            }
        }
        
        int answer = 0;
        while(!st.isEmpty()) {
            answer = st.pop();
        }

        return answer;

    }
}