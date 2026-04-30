class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];
        for (int[][] rr: dp) {
            for (int[] r: rr) {
                Arrays.fill(r, -1);
            }
        }

        int maxScore = dfsFun(grid, m, n, 0, 0, k, dp);
        return (maxScore < 0) ? -1 : maxScore;
    }
    public int dfsFun(int[][] grid, int m, int n, int cr, int cc, int k, int[][][] dp) {
        if (cr >= m || cc >= n || k < 0)
            return -1000000;
        
        if (cr == m-1 && cc == n-1)
            return (grid[cr][cc] > 0) ? ((k-1) >= 0 ? grid[cr][cc] : -1000000): grid[cr][cc];

        if (dp[cr][cc][k] != -1)
            return dp[cr][cc][k];

        int right = dfsFun(grid, m, n, cr, cc+1, (grid[cr][cc] > 0) ? k-1: k, dp);
        int down = dfsFun(grid, m, n, cr+1, cc, (grid[cr][cc] > 0) ? k-1: k, dp);
        
        return dp[cr][cc][k] = Math.max(right, down) + grid[cr][cc];
    }
}