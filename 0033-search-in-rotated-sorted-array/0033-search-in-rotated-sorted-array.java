class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int n = nums.length;
        int end = n - 1;

        // in rotated sorted array always remember 1 part will be sort
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {// means left part is sorted
                if(nums[start] <= target && nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if( nums[mid] <= target &&  nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
             }
        }
        
        return -1;
    }
}