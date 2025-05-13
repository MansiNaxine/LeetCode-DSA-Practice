class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //to find the first and last position we have to calculate upper and lower bound
        int n = nums.length;
        int answer[] = {-1, -1};
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] >= target) {
                
                end = mid - 1;
                if(nums[mid] == target) {
                    answer[0] = mid;
                }
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] <= target) {
                start = mid + 1;
                if(nums[mid] == target) {
                    answer[1] = mid;
                }
            } else {
                end = mid - 1;
            }
        }
        
        return answer;
    }
}