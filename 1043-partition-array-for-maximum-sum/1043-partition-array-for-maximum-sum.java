class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        //solve first in a recursive way
        // return recursion(0, n, arr, k);

        //MEMOIZATION
        int[] dp = new int[n + 1];
        return memoRecursion(0, n, arr, k, dp);
    }

    public int memoRecursion(int i, int n, int[] arr, int k, int[] dp) {
        //base case
        if(i >= n) return 0;

        if(dp[i] != 0) return dp[i];

        //recursive case
        int len = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int index = i; index < Math.min(n , i + k); index++) {
            len++;
            maxVal = Math.max(maxVal, arr[index]);
            int cost = (maxVal * len) + memoRecursion(index + 1, n, arr, k, dp);
            maxAns = Math.max(maxAns, cost);
        }

        return dp[i] = maxAns;
    }

    public int recursion(int i, int n, int[] arr, int k) {
        //base case
        if(i >= n) return 0;

        //recursive case
        int len = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int index = i; index < Math.min(n , i + k); index++) {
            len++;
            maxVal = Math.max(maxVal, arr[index]);
            int cost = (maxVal * len) + recursion(index + 1, n, arr, k);
            maxAns = Math.max(maxAns, cost);
        }

        return maxAns;
    }
}