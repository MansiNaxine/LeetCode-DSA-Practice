class Solution {
    public int numberOfSubstrings(String s) {

        int ans1 = getNumberOfStrings(s);
        return ans1;
        
    }

    public int getNumberOfStrings(String s) {
        int n = s.length();
        int cnt = 0;
        int freq[] = {-1, -1, -1};

        for(int i = 0 ; i < n; i++) {
            freq[s.charAt(i) - 'a'] = i;
            if(freq[0] != -1 && freq[1] != -1 && freq[2] != -1) {
                cnt += (1 + Math.min(freq[0], Math.min(freq[1], freq[2]))) ; 
            }
        }

        return cnt;
    }
}