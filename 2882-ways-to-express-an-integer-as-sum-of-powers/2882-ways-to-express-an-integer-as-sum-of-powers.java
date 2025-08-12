class Solution {
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return solveFun(n, x , 1, dp);
    }
    public int solveFun(int n, int x, int curr, int[][] dp) {
        if (n == 0)
            return 1;

        if (n < 0 || Math.pow(curr, x) > n)
            return 0;

        if (dp[n][curr] != -1)
            return dp[n][curr];

        int mod = 1000000007;

        int inc = solveFun(n-(int)Math.pow(curr, x), x, curr+1, dp) % mod;
        int exc = solveFun(n, x, curr+1, dp) % mod;

        return dp[n][curr] = (inc + exc) % mod;
    }
}