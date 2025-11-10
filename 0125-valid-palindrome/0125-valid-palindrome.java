class Solution {
    public boolean isPalindrome(String s) {

        if(s.length() == 0) return true;

        //1.Convert all letters into lower case letters
        String lowerCase = s.toLowerCase();

        //2.Capture all letters into 1 StringBuilder
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lowerCase.length(); i++) {
            int currentChar = (int)lowerCase.charAt(i);
            if((currentChar >= 48 && currentChar <= 57) || (currentChar >= 97 && currentChar <= 122)) {
                sb.append((char)currentChar);
            }
        }

        //3.Apply recursion by passing string, start, end
        return checkBoolean(sb.toString(), 0, sb.length() - 1);
        
    }

    public boolean checkBoolean(String str, int start, int end) {
        if(str.length() == 0) return true;

        if(start >= end) return true;

        if(str.charAt(start) != str.charAt(end)) {
            return false;
        } else {
            return checkBoolean(str, start+1, end-1);
        }
    }
}