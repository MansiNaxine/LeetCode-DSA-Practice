class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();

        while(j < n) {

            //Storing frequency of each character inside map
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            }

            
            int len = j - i + 1;
            int maxF = getMaxFreq(map);
            int diff = len - maxF;
            while(diff > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
                len = j - i + 1;
                maxF = getMaxFreq(map);
                diff = len - maxF;

            }

            if(diff <= k) {
                maxLen = Math.max(maxLen, len);
            }

            j++;
        }

        return maxLen;
        
    }

    public int getMaxFreq(Map<Character, Integer> map) {

        int maxF = 0;
        for(Integer val : map.values()) {
            if(val > maxF) {
                maxF = val;
            }
        }
        return maxF;
    }
}