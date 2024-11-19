class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);             // for min coins

        int[][] dp = new int[n][amount+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        int ans = countFun(coins, n-1, amount, dp);
        return (ans == Integer.MAX_VALUE - 1) ? -1 : ans;
    }
    public int countFun(int[] coins, int idx, int amount, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == -1)
            return Integer.MAX_VALUE-1;

        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int take = Integer.MAX_VALUE, not_take = 0;
        if (amount >= coins[idx])
            take = 1 + countFun(coins, idx, amount-coins[idx], dp);
        not_take = countFun(coins, idx-1, amount, dp);

        return dp[idx][amount] = Math.min(take, not_take);
    }
}