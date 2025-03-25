class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count);
        
    }
}