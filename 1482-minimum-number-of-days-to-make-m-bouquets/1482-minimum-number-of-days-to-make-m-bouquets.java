class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int flow : bloomDay) {
            min = Math.min(min, flow);
            max = Math.max(max, flow);
        }

        int ans = -1;
        if((m * k) > n) return -1;

        int start = min;
        int end = max;

        while(start <= end) {

            int mid = (start + end) /2;
            int possibleBouque = getNOfBouquets(bloomDay, mid, k);

            if(possibleBouque >= m) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public int getNOfBouquets(int[] bloomDay, int mid, int k) {
        
        int j = 0;
        int n = bloomDay.length;
        int cnt = 0;
        int bouque = 0;

        while(j < n) {
            if(bloomDay[j] <= mid) {
                cnt += 1;
            }
            else {
                cnt = 0;
            }

            if(cnt == k) {
                bouque += 1;
                cnt = 0;
            }

            j++;
        }

        return bouque;
    }
}