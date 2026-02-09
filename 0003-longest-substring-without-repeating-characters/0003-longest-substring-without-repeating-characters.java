class Solution {
    public int lengthOfLongestSubstring(String s) {

        //BruteForce Approach
        int answer = bruteForceApproach(s);
        return answer;
        
    }

    public int bruteForceApproach(String s) {

        int n = s.length();
        int maxLength = 0;
        

        for(int i = 0; i < n; i++) {
            String str = "";
            int freq[] = new int[256];
            for(int j = i; j < n; j++) {
                if(freq[(int) s.charAt(j)] == 0) {
                    freq[(int) s.charAt(j)]++;
                    str += s.charAt(j);
                }
                else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, str.length());
        }

        return maxLength;
    }
}