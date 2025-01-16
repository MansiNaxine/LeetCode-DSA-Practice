class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int index = 0;
        int i = 0;
        int j = 0;

        nums[index] = nums[i];
        index++;

        while(j < n) {
            
            if( nums[i] != nums[j]) {
                i = j;
                nums[index] = nums[i];
                index++;
            }
            j++;
        }
        
        return index;
    }
}