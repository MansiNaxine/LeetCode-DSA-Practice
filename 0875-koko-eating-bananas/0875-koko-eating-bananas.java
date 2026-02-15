class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        long start = 1;
        int max = Integer.MIN_VALUE;

        for(int num : piles) {
            max = Math.max(num, max);
        }

        long end = max;
        int ans = max;

        while(start <= end) {

            long mid = (long)(start + end)/2;
            long possibleHours = getPossibleHours(mid, piles);

            if(possibleHours <= h) {
                ans = (int) mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public long getPossibleHours(long mid, int[] piles) {

        long ans = 0;
        for(int num : piles) {
            if (num <= mid) {
                ans += 1;
            }
            else {
                ans += (num/mid);
                if(num%mid > 0) ans += 1;
            }
        }

        return ans;
    }
}