class Solution {
    public int[] sortedSquares(int[] nums) {

        int n=nums.length;

        //1.BruteForce Approach

        // for(int i=0;i<n;i++){
        //     nums[i] *= nums[i];
        // }

        // for(int i=0;i<n-1;i++){

        //     for(int j=0;j<n-1-i;j++){

        //         if(nums[j]>=nums[j+1]){

        //             int temp=nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]=temp;
        //         }
        //     }
        // }

        //2.Optimized Approach
        int answer[]=new int[n];
        int index=n-1;
        int i=0;
        int j=n-1;

        while(i<=j){

            if(Math.abs(nums[i])>=Math.abs(nums[j])){
                answer[index]=nums[i]*nums[i];
                i++;
            }else{
                answer[index]=nums[j]*nums[j];
                j--;
            }

            index--;

        }
        
        return answer;
    }
}