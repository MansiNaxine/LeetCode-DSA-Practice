class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        int element = -1;
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                element = nums[i];
                count++;
            } else {
                count = (nums[i] == element) ? count+1 : count-1;
            }
        }

        return element;
    }
}