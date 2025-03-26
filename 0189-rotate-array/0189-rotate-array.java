class Solution {
    public void rotate(int[] nums, int k) {
        //BruteForce Approach
        int n = nums.length;
        k = k % n;
        int index = 0;
        int arr[] = new int[n];

        for(int i = 0; i < k; i++) {
            arr[index] = nums[n - k + i];
            index++;
        }

        for(int i = 0; i < (n - k) ; i++) {
            arr[index] = nums[i];
            index++;
        }

        for(int j = 0; j < n; j++) {
            nums[j] = arr[j];
        }
        
    }
}