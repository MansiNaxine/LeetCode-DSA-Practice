class Solution {
    int answer = -1;
    public int search(int[] nums, int target) {

         helper(nums, target, 0, nums.length - 1);
         return answer;
    }

    public void helper(int[] nums, int target, int start, int end) {

        //base case
        if(start > end) {
            return;
        }


        int mid = (start + end) / 2;

        if(nums[mid] == target) {
            answer = mid;
            return;
        } 

        
        if(target < nums[mid]) {
            helper(nums, target, start, mid - 1);
        } else {
            helper(nums, target, mid + 1, end);
        }

        
    }
}