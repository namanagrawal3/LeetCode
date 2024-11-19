class Solution {
    public int numTilings(int n) {
        // Recurrence relation is :
        // f(n) = f(n-1) + f(n-2) + 2*f(n-3) + 2*f(n-4) + 2*f(n-5) + ---- + 2*f(0)
        // Thus, f(n) = 2*f(n-1) + f(n-3)

        int[] dp = new int[n+1];
        return tileFun(n, 1000000007, dp);
    }
    public int tileFun(int n, int mod, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 5;

        if (dp[n] != 0)
            return dp[n];

        int ways = ((2*tileFun(n-1, mod, dp)) % mod + tileFun(n-3, mod, dp) % mod) % mod;
        return dp[n] = ways;
    }
}