class Solution {
    public boolean canJump(int[] nums) {
        return helper(0, nums, nums.length, 0);
    }

    public boolean helper(int index, int[] nums, int n, int maxIndex) {
        if(maxIndex >= n - 1) return true;
        if(index == maxIndex && nums[maxIndex] == 0) return false;

        return helper(index + 1, nums, n, Math.max(maxIndex, index + nums[index]));
    }
}