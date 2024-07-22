class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target,true);
        int last=findFirst(nums,target,false);

        return new int[]{first,last};
    }

    public int findFirst(int[] nums,int target,boolean searchForFirsIndex){
        int ans=-1;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
                
            }else{
                //potential ans
                ans=mid;
                if(searchForFirsIndex){
                    end=mid-1;

                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }

   
} 