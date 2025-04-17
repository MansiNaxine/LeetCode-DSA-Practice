class Solution {
    public int countSubstrings(String s) {
        
        int len = s.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(isPalindrome(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String str) {
        int len = str.length();
        if(len == 1) return true;
        int i = 0;
        int j = len - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            } 
            i++;
            j--;
        }

        return true;
    }
}