class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        
        //recursive approach
        // return recursion(0, n - 1, s);

        //memoization
        int[][] dp = new int[n + 1][n];
        return memoRecursion(0, n - 1, s, dp);       

        //TABULATION
        // StringBuilder sb = new StringBuilder(s);
        // if(sb.reverse().toString().equals(s)) return 0;
        // else return tabulation(n, s, dp);
        
        // return tabulation(n, s, dp);
    }

    public int tabulation(int n, String s, int[] dp) {
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(i >= j || isPalindrome(s.substring(i, j + 1))) continue;
                else {
                    int minPart = 2000;
                    for(int index = i; index <= j; index++) {
                        if(isPalindrome(s.substring(i, index + 1))) {
                            int partition = 1 + dp[index + 1];
                            minPart = Math.min(minPart, partition);
                        }
                    }
                    dp[i] = minPart;
                }
            }
        }

        return dp[0];
    }

    public int memoRecursion(int i, int j, String s, int[][] dp) {
        //base case
        if(i >= j || isPalindrome(s.substring(i, j + 1))) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        //recursive case
        int minPart = 2000;
        for(int index = i; index <= j; index++) {
            if(isPalindrome(s.substring(i, index + 1))) {
                int partition = 1 + memoRecursion(index + 1, j, s, dp);
                minPart = Math.min(minPart, partition);
            }
        }

        return dp[i][j] = minPart;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }

    public int recursion(int i, int j, String s) {
        //base case
        if(i >= j || isPalindrome(s.substring(i, j + 1))) return 0;

        //recursive case
        int minPart = 2000;
        for(int index = i; index <= j; index++) {
            if(isPalindrome(s.substring(i, index + 1))) {
                int partition = 1 + recursion(index + 1, j, s);
                minPart = Math.min(minPart, partition);
            }
        }

        return minPart;
    }
}