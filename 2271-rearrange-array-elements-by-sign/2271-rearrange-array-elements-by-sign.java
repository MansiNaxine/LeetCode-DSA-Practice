class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int mid = n / 2;
        int aP[] = new int[mid];
        int bN[] = new int[mid];
        int k = 0;
        int l = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0) {
                aP[k] = nums[i];
                k++;
            } else {
                bN[l] = nums[i];
                l++;
            }
        }

        int index = 0;
        int j = 0;
        int m = 0;
        while(j < mid || m < mid) {
            if(index % 2 == 0) {
                nums[index] = aP[j];
                j++;
            } else {
                nums[index] = bN[m];
                m++;
            }
            index++;
        }
        
        return nums;
    }
}