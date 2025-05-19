class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        
        //calculate max from piles of bananas array to initiate the end variable
        long max = 0;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        long start = 1;
        long end = max;
        long answer = 1;

        while(start <= end) {
            long mid = (start + end) / 2;
            if(isPossible(mid, piles, h)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int)answer;
        
    }

    public boolean isPossible(long mid, int[] piles, int h) {

        long count = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] <= mid) {
                count += 1;
            } else if (piles[i] > mid) {
                if ((piles[i]%mid) != 0) {
                    count += piles[i]/mid + 1;
                } else {
                    count += piles[i]/mid;
                }
            }
        }

        return count <= h;
    }
}