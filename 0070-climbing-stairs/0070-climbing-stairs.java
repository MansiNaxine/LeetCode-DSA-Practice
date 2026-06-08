class Solution {
    public int climbStairs(int n) {
        
        //Solve Using DP
        // Memoization
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        return dpWithMemoization(ans, n);

    }

    public int dpWithMemoization(int[] ans, int n) {
        if(n <= 1) return 1;

        if(ans[n] != -1) return ans[n];
        return ans[n] = dpWithMemoization(ans, n - 1) + dpWithMemoization(ans, n - 2);
    }
}