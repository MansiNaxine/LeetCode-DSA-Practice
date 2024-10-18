class Solution {
    public int maximumDifference(int[] nums) {

        int i=0;
        int ans=-1;
        for(int j=i+1;j<nums.length;j++){
            int diff=-1;
            if(nums[i]<nums[j]){
                diff=nums[j]-nums[i];
            }else{
                i=j;
            }
            ans=Math.max(ans,diff);
        }

        return ans;
        
    }
}