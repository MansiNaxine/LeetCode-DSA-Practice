class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        if(n == 1) return start;

        while(start <= end) {
            int mid = (start + end) / 2;
            if((mid - 1) == -1) {
                if(nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if ((mid + 1) == n) {
                if(nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}