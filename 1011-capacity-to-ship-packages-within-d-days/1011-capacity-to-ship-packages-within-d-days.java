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
        int ans = -1;

        while(start <= end) {

            int mid = (start + end)/2;
            int possibleDays = getNoOfDays(weights, mid);

            if(possibleDays <= days) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return ans;
    }

    public int getNoOfDays(int[] weights, int mid) {

        int sum = 0;
        int days = 0;

        for(int weight : weights) {
            if((sum + weight) <= mid) {
                sum += weight;
            } else {
                days += 1;
                sum = weight;
                if(weight > mid) {
                    days += (weight/mid);
                    if((weight%mid) > 0 && (weight%mid) <= mid) days += 1;
                }
            }
        }

        if(sum != 0 && sum <= mid) return days + 1;
        else {
            days += (sum/mid);
            if((sum%mid) > 0 && (sum%mid) <= mid) days += 1;
            return days;
        }
    }
}