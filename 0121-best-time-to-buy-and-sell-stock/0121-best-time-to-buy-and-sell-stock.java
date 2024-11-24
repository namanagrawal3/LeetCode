class Solution {
    public int maxProfit(int[] prices) {
        // if I am selling the stock on the ith day, 
        // then I will buy the stock at the min price day before ith day
        int n = prices.length;
        int min = prices[0];
        int maxProfit = 0; 

        for (int i = 1; i < n; i++) {
            int profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}