class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }

        int ans = countFun(coins, 0, amount, dp);
        return (ans == 100000000) ? -1: ans;
    }
    public int countFun(int[] coins, int idx, int amount, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return 100000000;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int take = 100000000;
        if (amount >= coins[idx])
            take = 1 + countFun(coins, idx, amount-coins[idx], dp);
        int not_take = countFun(coins, idx+1, amount, dp);

        return dp[idx][amount] = Math.min(take, not_take);
    }
}