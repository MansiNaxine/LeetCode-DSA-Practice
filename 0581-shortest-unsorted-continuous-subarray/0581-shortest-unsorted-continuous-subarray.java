class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);

        int s = -1;
        int e = -2;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != sorted_nums[i]) {
                if (s == -1) s = i;
                else e = i;
            }
        }
        
        return e - s + 1;
    }
}