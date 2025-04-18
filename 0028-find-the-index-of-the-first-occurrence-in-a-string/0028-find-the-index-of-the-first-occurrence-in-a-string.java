class Solution {
    public int strStr(String haystack, String needle) {

        //find the index
        int answer = -1;
        int len = haystack.length();
        for(int i = 0; i <= len - needle.length(); i++) {
            if(haystack.substring(i , i + needle.length()).equals(needle)) {
                answer = i;
                break;
            }
        }

        return answer;
        
    }
}