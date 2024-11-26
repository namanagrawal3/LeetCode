class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return costFun(prices, 0, 1, dp);
    }
    public static int costFun(int[] prr, int idx, int isBuy, int[][] dp) {
        if (idx >= prr.length)
            return 0;

        if (dp[idx][isBuy] != -1)
            return dp[idx][isBuy];

        int maxProfit = Integer.MIN_VALUE;
        if (isBuy == 1) {
            int buy = -prr[idx] + costFun(prr, idx+1, 0, dp);
            int not_buy = costFun(prr, idx+1, 1, dp);
            maxProfit = Math.max(buy, not_buy);
        }
        else {
            int sell = prr[idx] + costFun(prr, idx+2, 1, dp);
            int not_sell = costFun(prr, idx+1, 0, dp);
            maxProfit = Math.max(sell, not_sell);
        }

        return dp[idx][isBuy] = maxProfit;
    }
}