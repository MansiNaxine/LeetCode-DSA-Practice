class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;

        while(start <= end) {
            
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                ans = mid;
                return true;
            }
            else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start = start + 1;
                end = end - 1;
            }
            else if (nums[start] <= nums[mid] ) {

                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {

                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}