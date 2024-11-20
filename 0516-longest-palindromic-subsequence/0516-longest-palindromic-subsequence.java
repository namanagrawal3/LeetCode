class Solution {
    public int longestPalindromeSubseq(String s) {
        // LPS(s) --> LCS(s, rev(s))
        
        int n = s.length();
        StringBuilder t = new StringBuilder(s);
        String b = t.reverse().toString();
        
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n][n];
    }
}