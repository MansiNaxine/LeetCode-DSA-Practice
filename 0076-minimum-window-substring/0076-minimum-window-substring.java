class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();
        int cnt = 0;
        int sIndex = -1;
        int endIndex = n;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int mIndex = 0;
        int minLen = Integer.MAX_VALUE;

        while(mIndex < m) {
            if (!map.containsKey(t.charAt(mIndex))) {
                map.put(t.charAt(mIndex), 1);
            }
            else {
                map.put(t.charAt(mIndex), map.get(t.charAt(mIndex)) + 1);
            }
            mIndex++;
        }

        while(r < n) {

            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), -1);
            }
            else {
                if(map.get(s.charAt(r)) > 0) {
                    cnt += 1;
                }
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }

            while(cnt == m) {
                if((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    endIndex = r + 1;
                    sIndex = l;
                }

                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);

                if(map.get(s.charAt(l)) > 0) {
                    cnt -= map.get(s.charAt(l));
                }

                l++;   

            }

            r++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, endIndex);
        
    }
}