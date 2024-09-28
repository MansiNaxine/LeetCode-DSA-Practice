class Solution {
    public int missingNumber(int[] nums) {
     
     int sum=0;
     for(int i=0;i<nums.length;i++){
        sum=sum+nums[i];
     }
     int n=nums.length;
     int sum2=(n*(n+1))/2;

     return sum2-sum;
    }
}