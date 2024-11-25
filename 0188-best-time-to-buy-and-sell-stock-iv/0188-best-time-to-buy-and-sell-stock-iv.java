class Solution {
    public int maxProfit(int k, int[] prices) {
        // we can make either 3D-dp array or we can combine the 'isBuy' with 'trans'
        // isBuy - "B S B S" (k = 2)

        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return costFun(prices, 0, 0, k, dp);
    }
    public int costFun(int[] prr, int idx, int isBuy, int k, int[][] dp) {
        if (idx == prr.length || isBuy == 2*k)
            return 0;

        if (dp[idx][isBuy] != -1)
            return dp[idx][isBuy];

        int maxProfit = Integer.MIN_VALUE;
        if (isBuy % 2 == 0) {
            int buy = -prr[idx] + costFun(prr, idx+1, isBuy+1, k, dp);
            int not_buy = costFun(prr, idx+1, isBuy, k, dp);
            maxProfit = Math.max(buy, not_buy);
        }
        else {
            int sell = prr[idx] + costFun(prr, idx+1, isBuy+1, k, dp);
            int not_sell = costFun(prr, idx+1, isBuy, k, dp);
            maxProfit = Math.max(sell, not_sell);
        }

        return dp[idx][isBuy] = maxProfit;
    }
}