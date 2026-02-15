class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        if(n == 1) return nums[0];

        while(start <= end) {

            int mid = (start + end)/2;

            if((mid > 0 && nums[mid] != nums[mid - 1]) && (mid < n - 1 && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            else if ((mid == 0 && nums[mid] != nums[mid + 1]) || (mid == n - 1 && nums[mid] != nums[mid - 1])) {
                return nums[mid];
            }
            else if ((mid%2 == 0 && nums[mid] == nums[mid + 1]) || (mid%2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return nums[0];
    }
}