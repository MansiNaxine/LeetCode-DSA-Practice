class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        //BruteForce Approach
        // int ans[] = new int[n];
        // int index = 0;
        // for(int i = 0; i < k; i++) {
        //     ans[index] = nums[n - k + i];
        //     index++;
        // }

        // for(int i = 0; i < n-k ; i++) {
        //     ans[index] = nums[i];
        //     index++;
        // }

        // for(int i = 0; i < n; i++) {
        //     nums[i] = ans[i];
        // }

        //Optimized Approach
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

        
    }

    public void reverse(int nums[], int i, int j) {

         while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
         }
    }
}