class Solution {
    public int[] shuffle(int[] nums, int n) {

        int i=0;
        int j=n;
        int k=0;
        int ans[]=new int[nums.length];
        while(i<nums.length && j<nums.length){
            
           if(i%2==0){
            ans[i]=nums[k];
            k++;
           }else{
            ans[i]=nums[j];
            j++;
           }

           i++;
        }
        
        return ans;
    }
}