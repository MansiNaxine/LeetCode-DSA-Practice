class Solution {
    public boolean isValid(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean ans = false;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if(st.size() >= 1) {
                    int topElement = st.pop();
                    if((ch == ')' && topElement == '(')) ans = true;
                    else if((ch == '}' && topElement == '{')) ans = true;
                    else if((ch == ']' && topElement == '[')) ans = true;
                    else  {
                        ans = false;
                        break;
                    }
                }
                else {
                    ans = false;
                    break;
                }
            }
        }

        return st.size() >= 1 ? false : ans;
        
    }
}