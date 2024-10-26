class Solution {
    public int removeDuplicates(int[] nums) {

        int i=0;
        int j=0;
        int index=0;

        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i=j;
                index++;
            }
            nums[index]=nums[i];
            j++;
        }

        return index+1;
        
    }
}