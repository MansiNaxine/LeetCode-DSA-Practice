class Solution {
    public int[] nextGreaterElements(int[] nums) {

        return bruteForceApproach(nums);
        
    }

    public int[] bruteForceApproach(int[] nums) {

        int n = nums.length;
        int[] nge = new int[n];

        for(int i = 0 ; i < n; i++) {
            nge[i] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            int ele = nums[i];
            for(int j = i + 1; j < (2 * n); j++) {
                if(nums[j%n] > nums[i]) {
                    nge[i] = nums[j%n];
                    break;
                }
            }

            if(nge[i] == ele) nge[i] = -1;
            
        }

        return nge;
    }
}