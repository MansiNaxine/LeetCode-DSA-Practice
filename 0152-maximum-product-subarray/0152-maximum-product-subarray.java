class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length == 1) return nums[0];
        int product = 1;
        int max = -10;

        int i = 0;
        int n = nums.length;
        int j = i;
        while(i < n && j < n) {
            
            product *= nums[j];
            max = Math.max(max, product);
            j++;

            if(j == n) {
                i++;
                j = i;
                product = 1;

            }

        }
            

        return max;
    }
}