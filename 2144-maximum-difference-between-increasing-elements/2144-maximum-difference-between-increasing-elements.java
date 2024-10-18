class Solution {
    public int maximumDifference(int[] nums) {

        int left=0;
        int ans=-1;
        for(int right=left+1;right<nums.length;right++){
            int diff=-1;
            if(nums[left]<nums[right]){
                diff=nums[right]-nums[left];
            }else{
                left=right;
            }

            ans=Math.max(ans,diff);
        }

        return ans;
        
    }
}