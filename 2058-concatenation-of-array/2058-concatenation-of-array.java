class Solution {
    public int[] getConcatenation(int[] nums) {

        int n=nums.length;
        int ans[]=new int[2*n];
        int i=0;
        int j=n;
        while(i<nums.length){
            ans[i]=nums[i];
            ans[j]=nums[i];
            i++;
            j++;
        }
        
        return ans;
    }
}