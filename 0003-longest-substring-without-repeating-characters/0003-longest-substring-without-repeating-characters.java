class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int answer = 0;
        int[] freq = new int[256];

        int i = 0; 
        int j = 0;

        while(j < n) {
            freq[(int) s.charAt(j)]++;

            while(i <= j && freq[(int) s.charAt(j)] > 1) {
                freq[(int) s.charAt(i)]--;
                i++;
            }

            answer = Math.max(answer, j - i + 1);
            j++;
        }
        
        return answer;
    }
}