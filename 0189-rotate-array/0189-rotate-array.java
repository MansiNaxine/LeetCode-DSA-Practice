class Solution {
    public void rotate(int[] nums, int k) {

        int arr[]=new int[k];
        int j=0;
        int n=nums.length;
        k=k%n;

        //place elements in new array from kth index;
        for(int i=n-k;i<n;i++){
            arr[j]=nums[i];
            j++;
        }

        //move elements from original array to the remaining index of nums and also from newly created array into original array;
        for(int i=n-1;i>=0;i--){
            if(i<k){
                nums[i]=arr[i];
            }else{
                nums[i]=nums[i-k];
            }
        }  
    }
}