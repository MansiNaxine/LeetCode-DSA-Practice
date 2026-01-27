class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = bloomDay.length;

        if((m * k) > n) return -1;

        for(int num :  bloomDay) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int start = min;
        int end = max;
        int ans = -1;

        while(start <= end) {

            int mid = (start + end)/2;
            int possibleBouquets = noOfBouquets(mid, bloomDay, k);

            if(possibleBouquets >= m) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public int noOfBouquets(int mid, int[] bloomDay, int k) {

        int cnt1 = k;
        int cnt2 = 0;
        int bouquets = 0;

        for(int num : bloomDay) {
            if(cnt1 == 0) cnt1 = k;
            if(num <= mid) {
                cnt2 += 1;
            } else {
                cnt2 = 0;
            }
            
            cnt1 -= 1;
            if(cnt2 == k) {
                bouquets += 1;
                cnt2 = 0;
            }
        }

        return bouquets;
    }
}