class Solution {
    public String getResultString(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            if(stack.isEmpty()) {
                if(s.charAt(i) == '#') continue;
                stack.push(s.charAt(i));
            } else {
                if(s.charAt(i) == '#') {
                    stack.pop();
                } else{
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        
        String a1 = getResultString(s);
        String b1 = getResultString(t);

        if(a1.equals(b1)) return true;


        return false;
    }
}