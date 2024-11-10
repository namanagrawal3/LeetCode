class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        for (int i = 0; i < dp.length; i++) {           // amount is 0 (Base-Case)
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int inc = 0;
                int exc = 0;

                if (j >= coins[i-1])
                    inc = dp[i][j-coins[i-1]];
                exc = dp[i-1][j];

                dp[i][j] = inc + exc;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}