class Solution {
    public int strStr(String haystack, String needle) {

        int len = haystack.length();
        for(int i = 0; i <= len - needle.length(); i++) {
            if(haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}