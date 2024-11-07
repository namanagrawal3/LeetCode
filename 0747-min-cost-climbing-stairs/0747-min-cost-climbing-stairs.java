class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            int oneStep = dp[i-1];
            int twoSteps = dp[i-2];
            dp[i] = Math.min(oneStep, twoSteps) + cost[i];
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}