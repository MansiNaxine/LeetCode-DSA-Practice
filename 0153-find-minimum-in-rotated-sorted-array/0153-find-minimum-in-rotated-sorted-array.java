class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;


        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[(mid - 1 + n) % n] > nums[mid] && nums[mid] < nums[(mid + 1) % n]) {
                return nums[mid];
            } else if (nums[start] <=  nums[end]) {
                return nums[start];
            } else if(nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            } 
        }

        
        
        return -1;
    }
}