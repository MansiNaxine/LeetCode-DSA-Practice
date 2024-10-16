class Solution {
    public void rotate(int[] nums, int k) {

        int arr[]=new int[k];
        //int j=0;
        int n=nums.length;
        k=k%n;

        //place elements in new array from kth index;
        // for(int i=n-k;i<n;i++){
        //     arr[j]=nums[i];
        //     j++;
        // }

        //move elements from original array to the remaining index of nums and also from newly created array into original array;
        // for(int i=n-1;i>=0;i--){
        //     nums[i]=i<k?arr[i]:nums[i-k];
        // }  

        //Second Approach
        //1.Reverse the array with constant space
        // for(int i=n-1,j=0;j<i;i--,j++){
        //     int temp=nums[i];
        //     nums[i]=nums[j];
        //     nums[j]=temp;
        // }

        // //2.Reverse till K and then reverse Remaining elements
        // for(int i=k-1,d=0;d<i;i--,d++){
        //     int temp=nums[d];
        //     nums[d]=nums[i];
        //     nums[i]=temp;
        // }

        // //3.Reverese the other remaining elements
        // for(int i=n-1,s=k;s<i;i--,s++){
        //     int temp=nums[s];
        //     nums[s]=nums[i];
        //     nums[i]=temp;
        // }

        //3. next approach to optimize time complexity
        int[] reverseArray1=reverseArray(nums,n-1,0);
        int[] reverseArray2=reverseArray(nums,k-1,0);
        int[] reverseArray3=reverseArray(nums,n-1,k);

    }

    public static int[] reverseArray(int[] nums,int i,int j){

        while(j<i){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i--;
            j++;
        }

        return nums;
    }
}