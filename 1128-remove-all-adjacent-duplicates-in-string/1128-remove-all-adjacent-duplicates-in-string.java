class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if(s.charAt(i) == stack.peek()) stack.pop();
                else stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
        
    }
}