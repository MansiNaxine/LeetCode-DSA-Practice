class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int o = 0;
        int z = 0;
        int t = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                z++;
            } else if (nums[i] == 1) {
                o++;
            } else {
                t++;
            }
        }

        int i = 0;
        while(z > 0) {
            nums[i] = 0;
            z--;
            i++;
        }

        while(o > 0) {
            nums[i] = 1;
            o--;
            i++;
        }

        while(t > 0) {
            nums[i] = 2;
            t--;
            i++;
        }
        
    }
}