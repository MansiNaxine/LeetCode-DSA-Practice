class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        int endIndex = -1;
        int startindex = -1;

        while(j < n) {
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), -1 );
            }
            else {
                if(map.get(s.charAt(j)) > 0) {
                    cnt += 1;
                }
                map.put(s.charAt(j),  map.get(s.charAt(j)) - 1 );
            }

            while(cnt == m) {
                int len = j - i + 1;
                if(len < minLen ) {
                    minLen = len;
                    endIndex = j + 1;
                    startindex = i;
                }
                map.put(s.charAt(i),  map.get(s.charAt(i)) + 1 );
                if(map.get(s.charAt(i)) > 0) cnt -= 1;
                
                i++;
            }

            j++;
        }

        return startindex == -1 ? "" : s.substring(startindex, endIndex);
        
    }
}