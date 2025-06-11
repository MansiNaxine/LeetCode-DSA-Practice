class Solution {
    public int maxDepth(String s) {

        int count = 0; 
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int max = 0;

        for(int i = 0; i < n; i++) {
                if(s.charAt(i) == '(') {
                    count++;
                }else if(s.charAt(i) == ')') {
                    count--;
                }

            st.push(s.charAt(i));
            max = Math.max(count,max);
        }

        return max;
        
    }
}