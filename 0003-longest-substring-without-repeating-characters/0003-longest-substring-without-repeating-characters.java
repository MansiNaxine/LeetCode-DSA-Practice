class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while(j < n) {
            if(!map.containsKey(s.charAt(j))) {
                int len = j - i + 1;
                if(len > maxLength) {
                    maxLength = len;
                }
                map.put(s.charAt(j), j);
            }
            else {
                int newIndex = map.get(s.charAt(j));
                while(i <= newIndex) {
                    map.remove(s.charAt(i));
                    i += 1;
                }
                map.put(s.charAt(j), j);
            }
            j++;
        }

        return maxLength;
        
    }
}