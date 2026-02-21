class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        

        while(j < n) {
            //inserting into map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while(map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1 );
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                i++;
            }

            if(map.size() <= k) {
                len = j - i + 1;
                if(len > maxLen) {
                    maxLen = len;
                }
            }
            j++;

        }
        
        return n <= k ? n : maxLen;
    }
}