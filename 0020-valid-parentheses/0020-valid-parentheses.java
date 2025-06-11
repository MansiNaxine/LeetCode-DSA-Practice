class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(st.isEmpty()) {
                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    count++;
                    st.push(s.charAt(i));
                } else{
                    return false;
                }
            }else{
                 if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    count++;
                    st.push(s.charAt(i));
                }else {
                    if(s.charAt(i) == ')' && st.pop() != '(' ||
                       s.charAt(i) == '}' && st.pop() != '{' ||
                       s.charAt(i) == ']' && st.pop() != '[') {
                        return false;
                       } else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' ){
                        count--;
                    }
                }
            }
        }

        return count == 0;
        
    }
}