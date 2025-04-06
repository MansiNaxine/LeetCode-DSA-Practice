class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int max = 0;
        int i = 0;
        int j = i + 1;

        while(i < prices.length && j < prices.length) {
            if(prices[j] > prices[i]) {
                profit =  prices[j] - prices[i];
                max = Math.max(max, profit);
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }

        return max;
    }
}