class Solution {
    public int[] buildArray(int[] nums) {

        int ans[]=new int[nums.length];
        for(int num:nums){
            ans[num]=nums[nums[num]];
        }
        
        return ans;
    }
}