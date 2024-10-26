class Solution {
    public void rotate(int[] nums, int k) {
        
        k=k%nums.length;

        // int r=0;
        // //first place the elements fron kth index to rotateArray array
        // for(int i=nums.length-k;i<nums.length;i++){
        //     rotateArray[r]=nums[i];
        //     r++;
        // }
        // //shift all the elements in nums array from 0th index to last i.e. after kth index
        // for(int i=nums.length-1;i>=k;i--){
        //     nums[i]=nums[i-k];
        // }

        // //copy elements from rotateArray
        // for(int i=0;i<k;i++){
        //     nums[i]=rotateArray[i];
        // }

        //Second Reverse approach
        int[] reverseArray1=reverseArray(0,nums.length-1,nums);
        int[] reverseArray2=reverseArray(0,k-1,nums);
        int[] reverseArray3=reverseArray(k,nums.length-1,nums);




    }

    public int[] reverseArray(int i,int j,int[] arr){

        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;
        }

        return arr;
    }
}