class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0;  i < s.length();  i++) {
            char ch = s.charAt(i);

            if(String.valueOf(ch).matches("^[a-z0-9]+$")) {
                sb.append(s.charAt(i));
            } 
        }

        String p = reverse(sb.toString(), "", sb.length()-1);
        String up = sb.toString();

        return up.equals(p);
        
    }

    public String reverse(String up, String p, int len) {
        if(len == -1) {
            return p;
        }

        char ch = up.charAt(len);
        return reverse(up, p + ch, len - 1);
    }
}