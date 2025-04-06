class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int count = 0;
        int index = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                count++;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }

        while(count > 0) {
            nums[index] = 0;
            count--;
            index++;
        }
    }
}