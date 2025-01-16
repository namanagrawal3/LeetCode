class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove+1][m][n];
        for (int[][] rr : dp) {
            for (int[] r : rr) {
                Arrays.fill(r, -1);
            }
        }

        return countPath(m, n, maxMove, startRow, startColumn, dp);
    }
    public int countPath(int m, int n, int maxMove, int cr, int cc, int[][][] dp) {
        if (maxMove < 0)
            return 0;
        if (cr < 0 || cr >= m || cc < 0 || cc >= n) 
            return 1;

        if (dp[maxMove][cr][cc] != -1)
            return dp[maxMove][cr][cc];
        
        int top = countPath(m, n, maxMove-1, cr-1, cc, dp) % mod;
        int bottom = countPath(m, n, maxMove-1, cr+1, cc, dp) % mod;
        int left = countPath(m, n, maxMove-1, cr, cc-1, dp) % mod;
        int right = countPath(m, n, maxMove-1, cr, cc+1, dp) % mod;

        return dp[maxMove][cr][cc] = ((top+bottom) % mod + (left+right) % mod) % mod;
    }
}