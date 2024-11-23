class Solution {
    public int twoEggDrop(int n) {
        int k = 2;     // eggs          
        int[][] dp = new int[k+1][n+1];         // Egg Drop Problem
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return trialFun1(k, n, dp);
    }
    public int trialFun1(int eggs, int floors, int[][] dp) {
        if (floors == 0 || floors == 1)
            return floors;
        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int minTrials = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int breaks = -1, not_break = -1;
            if (dp[eggs-1][k-1] != -1)
                breaks = dp[eggs-1][k-1];
            else {
                breaks = trialFun1(eggs-1, k-1, dp);
                dp[eggs-1][k-1] = breaks;
            }

            if (dp[eggs][floors-k] != -1)
                not_break = dp[eggs][floors-k];
            else {
                not_break = trialFun1(eggs, floors-k, dp);
                dp[eggs][floors-k] = not_break;
            }

            int trials = 1 + Math.max(breaks, not_break);
            minTrials = Math.min(minTrials, trials);
        }

        return dp[eggs][floors] = minTrials;
    }
}