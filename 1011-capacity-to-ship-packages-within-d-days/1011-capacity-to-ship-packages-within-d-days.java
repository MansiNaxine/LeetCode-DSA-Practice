class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        int start = max;
        int end = sum;
        int ans = max;

        while(start <= end) {

            int mid = (start + end)/2;
            int possibleDays = getPossibleDays(weights, mid);

            if (possibleDays <= days) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
        
    }

    public int getPossibleDays(int[] weights, int mid) {

        int sum = 0;
        int days = 0;
        for(int weight : weights) {
            if((sum + weight) <= mid) {
                sum += weight;
            }
            else {
                days += 1;
                sum = weight;
            }


        }

        return days + 1;
    }
}