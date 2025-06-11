class Solution {
    public String removeDuplicates(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                st.push(s.charAt(i)); 
            } else {
                char ch = st.peek();
                if(ch == s.charAt(i)) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
        
    }
}