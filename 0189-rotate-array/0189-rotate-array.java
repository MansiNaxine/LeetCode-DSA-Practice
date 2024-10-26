class Solution {
    public void rotate(int[] nums, int k) {
        
        k=k%nums.length;

        int rotateArray[]=new int[k];

        int r=0;
        //first place the elements fron kth index to rotateArray array
        for(int i=nums.length-k;i<nums.length;i++){
            rotateArray[r]=nums[i];
            r++;
        }
        //shift all the elements in nums array from 0th index to last i.e. after kth index
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[i-k];
        }

        //copy elements from rotateArray
        for(int i=0;i<k;i++){
            nums[i]=rotateArray[i];
        }
    }
}