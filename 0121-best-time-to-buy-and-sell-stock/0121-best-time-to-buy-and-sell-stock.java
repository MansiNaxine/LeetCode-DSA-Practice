class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < n; i++) {
            int cost = prices[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(prices[i], min);
        }

        return profit;
        
    }
}