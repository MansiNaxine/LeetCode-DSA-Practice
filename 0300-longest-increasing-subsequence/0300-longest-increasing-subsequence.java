class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int prevIndex = -1;
        //bruteForce Approach
        //recursion
        //return recursion(nums, n, 0, -1);

        //MEMOIZATION
        // int[][] dp = new int[n][n];
        // return memoRecursion(nums, n, 0, -1, dp);

        //USING BINARY SEARCH TECHNIQUE
        return binarySearchSol(nums, n);
    }

    public int binarySearchSol(int[] nums, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        int len = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > arr.get(arr.size() - 1)) {
                arr.add(nums[i]);
                len++;
            }
            else {
                findLowerBoundAndPlaceTheEle(arr, nums[i], n);
            }
        }

        return len;
    }

    public void findLowerBoundAndPlaceTheEle(ArrayList<Integer> nums, int ele, int n) {
        int start = 0;
        int end = nums.size() - 1;
        int ans = 0;

        while(start <= end) {
            int mid = (start + end)/2;
            if (nums.get(mid) >= ele) {
                ans = mid;
                end--;
            }
            else {
                start++;
            }
        }
        nums.set(ans, ele);
    }

    public int memoRecursion(int[] nums, int n, int index, int prev, int[][] dp) {
        //base case
        if(index == n) return 0;

        if(dp[index][prev + 1] != 0) return dp[index][prev + 1];

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]) take = 1 + memoRecursion(nums, n, index + 1, index, dp);
        int notTake = memoRecursion(nums, n, index + 1, prev, dp);

        return dp[index][prev + 1] = Math.max(take, notTake);
    }

    public int recursion(int[] nums, int n, int index, int prev) {
        //base case
        if(index == n) return 0;

        int take = 0;
        if(prev == -1 || nums[index] > nums[prev]) take = 1 + recursion(nums, n, index + 1, index);
        int notTake = recursion(nums, n, index + 1, prev);

        return Math.max(take, notTake);
    }
}