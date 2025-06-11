class Solution {
    public String getFormattedString(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                if(s.charAt(i) == '#') continue;
                else st.push(s.charAt(i));
            } else {
                if(s.charAt(i) == '#') {
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

        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        
      String A = getFormattedString(s);
      String B = getFormattedString(t);

      if(A.equalsIgnoreCase(B)) return true;

      return false;
    }
}