class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        //base cases
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int start = 0;
        int end = n - 1;

        while(start <= end) {

            int mid = (start + end) / 2;

            if ((mid != 0 && nums[mid] != nums[mid - 1]) && ( mid != n - 1 && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            else if (nums[mid] == nums[mid - 1]) {
                if((mid - 1)%2 == 0) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else if (nums[mid] == nums[mid + 1]){
                if((mid + 1)%2 == 0) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
                
            }
        }

        return nums[n - 1];
        
    }
}