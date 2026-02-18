class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int sum = 0;
        int[] freq = {-1, -1, -1};
        int i = 0;
        int cnt = 0;

        while(i < n) {
            //inserting frequencies of characters
            freq[(int) (s.charAt(i) - 'a')] = i;

            if(freq[0] != -1 && freq[1] != -1 && freq[2] != -1) {
                cnt +=  (Math.min(freq[0], Math.min(freq[1], freq[2])) + 1);
            }
            i++;
        }

        return cnt;
        
    }
}