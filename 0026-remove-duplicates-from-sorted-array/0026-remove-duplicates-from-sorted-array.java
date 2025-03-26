class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = 0;
        nums[i] = nums[j];
        while(j < n) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        
        return i + 1;
    }
}