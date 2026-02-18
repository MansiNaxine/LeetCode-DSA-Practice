class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while(j < n) {

            if(map.containsKey(s.charAt(j))) {
                int newIndex = map.get(s.charAt(j));
                i = i <= newIndex ? newIndex + 1 : i;
            }
            int len = j - i + 1;
            if(len > maxLength) {
                maxLength = len;
            }
            map.put(s.charAt(j), j);
            j++;
        }

        return maxLength;
        
    }
}