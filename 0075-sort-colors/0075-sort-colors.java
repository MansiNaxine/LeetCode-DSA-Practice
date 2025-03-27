class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int z = 0;
        int o = 0;
        int t = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                z++;
            } else if(nums[i] == 1) {
                o++;
            } else {
                t++;
            }
        }

        int j = 0;
        while(j < n && z > 0) {
            nums[j] = 0;
            j++;
            z--;
        }

        while(j < n && o > 0) {
            nums[j] = 1;
            j++;
            o--;
        }

        while(j < n && t > 0) {
            nums[j] = 2;
            j++;
            t--;
        }
    }
}