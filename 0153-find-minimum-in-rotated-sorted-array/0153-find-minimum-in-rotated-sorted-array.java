class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){

            int mid = (start + end)/2;

            //check if previous and next element is larger than mid
            if(nums[(mid - 1 + n )%n] > nums[mid] && nums[mid] < nums[(mid + 1)%n]){

                return nums[mid];
            }
            else if(nums[start] <= nums[mid] && nums[mid] <= nums[end]){

                return nums[start];
            }
            else if(nums[start] <= nums[mid]){

                start = mid + 1;
            }
            else{

                end = mid - 1;
            }
        }
        
        return nums[0];
    }
}