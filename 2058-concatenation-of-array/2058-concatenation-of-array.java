class Solution {
    public int[] getConcatenation(int[] nums) {

        int len=nums.length;
        int i=0;
        int j=0;
        int ans[]=new int[len*2];
        while(i<len){
            ans[i]=nums[i];
            i++;
        }

        while(i<ans.length){
            ans[i]=nums[j];
            i++;
            j++;
        }

        return ans;
    }
}