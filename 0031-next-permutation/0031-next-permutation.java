class Solution {
    public void nextPermutation(int[] nums) {

        //we have to find lexiographically next permutation combination
        int n = nums.length;
        int i = n - 2;

        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if( i >= 0) {
            int j = n - 1;
            while( nums[j] <= nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        

        int k = i + 1;
        int m = n -1;

        while(k < m) {

            int temp1 = nums[k];
            nums[k] = nums[m];
            nums[m] =temp1;

            k++;
            m--;
        }

        
    }
}