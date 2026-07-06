class Solution {
    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(0);

        //adding all elements from cuts arr to list arr
        for(int i = 0; i < m; i++) {
            arr.add(cuts[i]);
        }

        arr.add(n);
        Collections.sort(arr);

        // return recursion(1, m, arr);

        //MEMOIZATION
        int[][] dp = new int[m + 2][m + 1];
        // return memoRecursion(1, m, arr, dp);

        //TABULATION
        return tabulation(m, arr, dp);
    }

    public int tabulation(int m, List<Integer> arr, int[][] dp) {

        for(int i = m; i >= 1; i--) {
            for(int j = i; j <= m ; j++) {
                int min = Integer.MAX_VALUE;
                for(int index = i; index <= j; index++) {
                    int cost = arr.get(j + 1) - arr.get(i - 1) + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.min(cost, min);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][m];
    }

    public int memoRecursion(int i, int j, List<Integer> arr, int[][] dp) {
        //base case
        if(i > j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        //recursive case
        int min = Integer.MAX_VALUE;
        for(int index = i; index <= j; index++) {
            int cost = arr.get(j + 1) - arr.get(i - 1) + memoRecursion(i, index - 1, arr, dp) + memoRecursion(index + 1, j, arr, dp);
            min = Math.min(cost, min);
        }

        return dp[i][j] = min;
    }

    public int recursion(int i, int j, List<Integer> arr) {
        //base case
        if(i > j) return 0;

        //recursive case
        int min = Integer.MAX_VALUE;
        for(int index = i; index <= j; index++) {
            int cost = arr.get(j + 1) - arr.get(i - 1) + recursion(i, index - 1, arr) + recursion(index + 1, j, arr);
            min = Math.min(cost, min);
        }

        return min;
    }
}