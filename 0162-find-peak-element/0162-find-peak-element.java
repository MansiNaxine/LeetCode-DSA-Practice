class Solution {
    public int findPeakElement(int[] nums) {
        //[1,2,3,1]
        //[1,2,1,3,5,6,4]

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        //edge condition
        if(n == 1) return 0;

        while(start <= end) {

            int mid = (start + end)/2;

            if((mid > 0 && nums[mid] > nums[mid - 1]) && (mid < n - 1 && nums[mid] > nums[mid + 1])) {
                return mid;
            }
            else if ((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == n - 1 && nums[mid] > nums[mid - 1])) {
                return mid;
            }
            else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;

    }
}