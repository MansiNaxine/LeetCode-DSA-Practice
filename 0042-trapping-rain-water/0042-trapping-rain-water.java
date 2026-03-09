class Solution {
    public int trap(int[] height) {
        
        //First calculate the prefix sum
        int pm = Integer.MIN_VALUE;
        int n = height.length;
        // int[] pmax = new int[n];

        // for(int i = 0 ; i < n; i++) {
        //     pm = Math.max(pm, height[i]);
        //     pmax[i] = pm;
        // }
        
        //Calculate Suffiox Sum
        int sm = Integer.MIN_VALUE;
        int[] smax = new int[n];
        for(int i = n - 1 ; i >= 0; i--) {
            sm = Math.max(sm, height[i]);
            smax[i] = sm;
        }

        //Calculate the area
        int area = 0;
        for(int i = 0; i < n; i++) {
            pm = Math.max(pm, height[i]);
            int right = smax[i];
            if(height[i] < pm && height[i] < right) {
                int min = Math.min(pm, right);
                area += (min - height[i]);
            }
        }

        return area;
    }
}