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
        int[][] dp = new int[m + 1][m + 1];
        return memoRecursion(1, m, arr, dp);
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