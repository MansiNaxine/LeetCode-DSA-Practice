class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        Stack<Character> st = new Stack<>();
        if(n == k) return "0";
        
        for(int i = 0; i < n; i++) {
            
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        while(k > 0) {
            st.pop();
            k--;
        }
         return reverseString(st);
    }

    public String reverseString(Stack<Character> st) {
        StringBuilder sb = new StringBuilder("");
        int m = st.size();
        for(int i = 0 ; i < m; i++) {
            sb.append(st.pop());
        }

        String ans = sb.reverse().toString();
        for(int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) > '0') {
                return ans.substring(i, ans.length());
            }
        }

        return "0";
    }
}