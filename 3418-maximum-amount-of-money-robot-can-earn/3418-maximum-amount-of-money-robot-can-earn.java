class Solution {
    public int maximumAmount(int[][] coins) {
    // Simply try all poosible combinations using 'Recursion' (Top-Down)
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][2+1];
        for (int[][] rr: dp) {
            for (int[] r: rr) {
                Arrays.fill(r, Integer.MIN_VALUE);
            }
        }

        // for (int[] r: dp) {
        //     System.out.println(Arrays.toString(r));
        // }
        return maxAmount(coins, m, n, 0, 0, 2, dp);
    }
    public int maxAmount(int[][] coins, int m, int n, int cr, int cc, int k, int[][][] dp) {
        if (cr == m || cc == n)
            return -1000000;

        if (dp[cr][cc][k] != Integer.MIN_VALUE)
            return dp[cr][cc][k];
        
        if (cr == m-1 && cc == n-1) {
            if (coins[cr][cc] >= 0)
                return dp[cr][cc][k] = coins[cr][cc];
            if (k > 0)
                return dp[cr][cc][k] = 0;
            return dp[cr][cc][k] = coins[cr][cc]; 
        }
        
        int max = Integer.MIN_VALUE;
        if (coins[cr][cc] >= 0) {
            int right = coins[cr][cc] + maxAmount(coins, m, n, cr, cc+1, k, dp);
            int down = coins[cr][cc] + maxAmount(coins, m, n, cr+1, cc, k, dp);
            max = Math.max(right, down);
        }
        else {
            if (k > 0) {
                int right1 = 0 + maxAmount(coins, m, n, cr, cc+1, k-1, dp);
                int right2 = coins[cr][cc] + maxAmount(coins, m, n, cr, cc+1, k, dp);
                int down1 = 0 + maxAmount(coins, m, n, cr+1, cc, k-1, dp);
                int down2 = coins[cr][cc] + maxAmount(coins, m, n, cr+1, cc, k, dp);
                max = Math.max(Math.max(right1, right2), Math.max(down1, down2));
            }
            else {
                int right = coins[cr][cc] + maxAmount(coins, m, n, cr, cc+1, k, dp);
                int down = coins[cr][cc] + maxAmount(coins, m, n, cr+1, cc, k, dp);
                max = Math.max(right, down);
            }
        }

        return dp[cr][cc][k] = max;
    }
}