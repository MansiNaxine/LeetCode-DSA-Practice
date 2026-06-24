class Solution {
    public int longestStrChain(String[] words) {

        int n = words.length;
        Arrays.sort(words, (x, y) -> Integer.compare(x.length(), y.length()));
        System.out.println(Arrays.toString(words));
        return modifiedTabulation(words, n);
        
    }

    public int modifiedTabulation(String[] nums, int n) {
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int maxAns = 0;
        int lastIndex = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(checkPossibleStrings(nums[i], nums[j]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            
            maxAns = Math.max(maxAns, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        
        return maxAns;
    }

    public boolean checkPossibleStrings(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int unMatch = 0;

        int totalLen = len1 + len2;
        if(len1 - len2 != 1) return false;

        int i = 0;
        int j = 0;
        while(i < len1 && j < len2) {
            if(a.charAt(i) == b.charAt(j)) j++;

            i++;
        }

        return i - j <= 1;
    }
}