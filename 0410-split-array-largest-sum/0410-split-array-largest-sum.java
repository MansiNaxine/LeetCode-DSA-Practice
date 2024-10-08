class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;

        for(int i=0;i<nums.length;i++){
            start=Math.max(start,nums[i]);
            end +=nums[i];
        }
        
        while(start<end){
            int mid=start+(end-start)/2;

                int sum=0;
                int pieces=1;

            for(int num:nums){
                //If sum with the next number has been increased than mid then form next array and increase the   array count accordingly else individual element will be the sum
                if(sum+num>mid){
                    sum=num;
                    pieces++;
                }else{
                    sum +=num;
                }
            }

            if(pieces<=k){
                end=mid;
            }else{
                start=mid+1;
            }

           
        }

        //return start or end both will be same.
         return start;
    }
}