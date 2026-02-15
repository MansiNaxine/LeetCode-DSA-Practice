class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        int start = 1;
        int max = Integer.MIN_VALUE;

        for(int num :  nums) {
            max = Math.max(num, max);
        }

        int end = max;
        int ans = -1;

        while(start <= end) {

            int mid = (start + end)/2;
            int possibleThreshold = getPossibleThreshold(nums, mid);

            if (possibleThreshold <= threshold) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int getPossibleThreshold(int[] nums, int mid) {

        int cnt = 0;
        for(int num : nums) {
            if(num <= mid) {
                cnt += 1;
            }
            else {
                cnt += (num/mid);
                if(num%mid > 0) cnt += 1;
            }
        }

        return cnt;
    }
}