class Solution {
    public int lengthOfLongestSubstring(String s) {

        //BruteForce Approach
        //Time Complexity is taking O(N^2)
        // int answer = bruteForceApproach(s);

        //Optimal Solution Using Sliding window and two pointer concepts
        int answer = optimalApproach(s);
        return answer;
        
    }

    public int optimalApproach(String s) {

        int n = s.length();
        int maxLen = 0;
        //Take map to store character and index position
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        while(right < n) {
            
            if(map.containsKey(s.charAt(right)) && left <= map.get(s.charAt(right))) {
              left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, (right - left + 1));
            right += 1;

        }

        return maxLen;

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