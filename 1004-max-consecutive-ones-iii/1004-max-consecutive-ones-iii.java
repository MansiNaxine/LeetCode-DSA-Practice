class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int zeros = 0;

        while(j < n) {
            while(zeros > k && i < j) {
                if(nums[i] == 0) {
                    zeros -= 1;
                }
                i++;
            }

            if(nums[j] == 0) {
                    zeros += 1;
                }

            if(zeros <= k) {
                
                maxLen = Math.max(maxLen, (j - i + 1));
                
            }
            j++;
        }

        return maxLen;
    }
}