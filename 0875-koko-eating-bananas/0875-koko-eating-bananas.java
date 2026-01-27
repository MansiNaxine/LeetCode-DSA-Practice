class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        long max = Integer.MIN_VALUE;

        for(int num : piles) {
            max = Math.max(max, num);
        }

        long start = 1;
        long end = max;
        long ans = -1;

        while(start <= end) {

            long mid = (start + end)/2;
            long actualHours = isPossible(mid, piles);
            if (actualHours <= h) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return (int)ans;
    }

    public long isPossible(long mid, int[] piles) {

        long count = 0;
        for(int num : piles) {
            if(num <= mid) {
                count += 1;
            } 
            else {
                count += (num/mid);
                if(num%mid > 0 && num%mid <= mid) count += 1;
            }
        }

        return count;
    }
}