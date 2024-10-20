class Solution {

    
    public int findUnsortedSubarray(int[] nums) {

        int first=-1;
        int last=-2;

        int copy_arr[]=nums.clone();
        Arrays.sort(copy_arr);

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=copy_arr[i]){
                if(first==-1){
                    first=i;
                }else{
                    last=i;
                }
            }
        }

        return last-first+1;
    }
}