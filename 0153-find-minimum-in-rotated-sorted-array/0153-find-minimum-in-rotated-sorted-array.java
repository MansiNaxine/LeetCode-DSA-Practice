class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        //base cases
        if(n == 1) return nums[0];
        if(n == 2 && nums[0] < nums[1]) return nums[0];
        if(n == 2 && nums[0] > nums[1]) return nums[1];
        if(nums[0] < nums[n - 1]) return nums[0];

        //Binary Search
        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end)/2;

            if(mid == 0 && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            else if (mid == n - 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else if ((mid != 0 && nums[mid] < nums[mid - 1]) && (mid != n - 1 && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            else if (nums[start] <= nums[mid] && nums[mid] > nums[end]){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}