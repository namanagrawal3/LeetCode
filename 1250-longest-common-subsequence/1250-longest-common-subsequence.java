class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    int one = dp[i-1][j];
                    int two = dp[i][j-1];
                    dp[i][j] = Math.max(one, two);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}