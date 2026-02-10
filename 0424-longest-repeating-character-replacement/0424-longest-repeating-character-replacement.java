class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int r = 0;
        int l = 0;
        int maxLen = 1;
        int diff = 0;
        int maxF = Integer.MIN_VALUE;
        int len = 0;
        
        //map will be of 26 size as uestion only contains 26 UPPERCASE letters
        Map<Character, Integer> map = new HashMap<>();
        
        while(r < n) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), 1);
            }
            else {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            }

            len = (r - l + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));
            diff = len - maxF;

            if(diff > k && l <= r) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                // if(map.get(s.charAt(l)) == 0) {
                //     map.remove(s.charAt(l));
                //     len = (r - l + 1);
                //     maxF = Math.max(maxF, map.get(s.charAt(l)));
                //     diff = len - maxF;
                // }
                l++;
            }

            if(diff <= k) {
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }


        return maxLen;

        
    }

    public int calculateMaxF(Map<Character, Integer> map) {
        int maxF = 0;

        for(Map.Entry<Character, Integer> mp : map.entrySet()) {
            maxF = Math.max(maxF, mp.getValue());
        }

        return maxF;
    }
}