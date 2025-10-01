class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0;  i < s.length();  i++) {
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57 ) || (s.charAt(i) >= 97 && s.charAt(i) <= 122) ) {
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