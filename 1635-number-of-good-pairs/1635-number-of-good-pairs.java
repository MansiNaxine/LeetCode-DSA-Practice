class Solution {
    public int numIdenticalPairs(int[] nums) {

        //with more time complexity O(n*n)
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        // }

        // return count;

        //with O(n) time complexity
        int count=0;
        int ans=0;
        int fre_arr[]=new int[101];

        for(int i=0;i<nums.length;i++){
             fre_arr[nums[i]]++;
        }

        for(int i=0;i<fre_arr.length;i++){
            if(fre_arr[i]>1){
                int n=fre_arr[i];
                ans +=n*(n-1)/2;
            }
        }
       
        return ans;
        
    }
}