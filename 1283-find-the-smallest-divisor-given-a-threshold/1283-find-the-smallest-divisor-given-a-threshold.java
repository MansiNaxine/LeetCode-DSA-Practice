class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        int start = 1;
        int end = max;
        int ans = -1;

        while(start <= end) {

            int mid = (start + end)/2;
            int thresholdCalculated = getThreshold(nums, mid);

            if(thresholdCalculated <= threshold) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public int getThreshold(int[] nums, int mid) {
        int ans = 0;

        for(int num : nums) {
                ans += num/mid;
                if((num%mid) > 0 && (num % mid) <= mid) ans += 1;
        }

        return ans;
    }
}