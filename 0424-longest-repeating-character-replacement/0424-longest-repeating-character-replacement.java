class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLen = 1;
        int maxF = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(j < n) {

            //Storing frequency of each character inside map
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }

            
            int len = j - i + 1;
            maxF = Math.max(maxF, map.get(s.charAt(j)));
            int diff = len - maxF;
            while(diff > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
                len -= 1;
                maxF = Math.max(maxF, map.get(s.charAt(i)));
                diff = len - maxF;

            }

            if(diff <= k) {
                maxLen = Math.max(maxLen, len);
            }

            j++;
        }

        return maxLen;
        
    }
}