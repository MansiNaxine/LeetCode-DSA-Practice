class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;  i < s.length();  i++) {
            char ch = s.charAt(i);
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57 ) || (s.charAt(i) >= 97 && s.charAt(i) <= 122) ) {
                sb.append(s.charAt(i));
            } 
            //String.valueOf(ch).matches("^[a-z0-9]+$")
        }

       // String p = reverse(sb.toString(), "", sb.length() >= 1 ? sb.length() - 1 : 0);
        String up = sb.toString();
       // up = up.substring(0, up.length()/2);

        return up.equals(sb.reverse().toString());
        
    }

    public String reverse(String up, String p, int len) {
        if(len == up.length()/2) {
            return p;
        }

        char ch = up.charAt(len);
        return reverse(up, p + ch, len - 1);
    }
}