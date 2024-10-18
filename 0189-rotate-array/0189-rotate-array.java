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

        //move elements from original array to the remaining index of nums;
        for(int i=n-1;i>=k;i--){
            nums[i]=nums[i-k];
        }

        //move elements which are stored in new created arr into nums;
        for(int i=0;i<k;i++){
            nums[i]=arr[i];
        }

        
    }
}