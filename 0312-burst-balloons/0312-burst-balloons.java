class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 0; i < n; i++) {
            list.add(nums[i]);
        }

        list.add(1);

        //recursive approach, we will solve it in a reverse order like we will pick the last element
        // return recursion(1, n, list);      

        //MEMOIZATION
        int[][] dp = new int[n + 1][n + 1];
        return memoRecursion(1, n, list, dp);
    }

    public int memoRecursion(int i, int j, List<Integer> list, int[][] dp) {
        //base case
        if(i > j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        //recursivec case
        int maxVal = Integer.MIN_VALUE;
        for(int index = i; index <= j; index++) {
            int cost = list.get(j + 1) * list.get(index) * list.get(i - 1) + memoRecursion(i, index - 1, list, dp) + memoRecursion(index + 1, j, list, dp);
            maxVal = Math.max(cost, maxVal);
        }

        return dp[i][j] = maxVal;

    }

    public int recursion(int i, int j, List<Integer> list) {
        //base case
        if(i > j) return 0;

        //recursivec case
        int maxVal = Integer.MIN_VALUE;
        for(int index = i; index <= j; index++) {
            int cost = list.get(j + 1) * list.get(index) * list.get(i - 1) + recursion(i, index - 1, list) + recursion(index + 1, j, list);
            maxVal = Math.max(cost, maxVal);
        }

        return maxVal;
    }
}