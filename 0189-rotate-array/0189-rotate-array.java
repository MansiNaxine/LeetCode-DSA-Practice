class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int ans[] = new int[n];
        int index = 0;
        for(int i = 0; i < k; i++) {
            ans[index] = nums[n - k + i];
            index++;
        }

        for(int i = 0; i < n-k ; i++) {
            ans[index] = nums[i];
            index++;
        }

        for(int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
        
    }
}