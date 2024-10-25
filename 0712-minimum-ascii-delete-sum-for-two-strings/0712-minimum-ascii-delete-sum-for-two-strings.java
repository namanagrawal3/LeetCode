class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int row = 1; row < dp.length; row++) {         // base-cases
            dp[row][0] = dp[row-1][0] + (int) s1.charAt(row-1);
        }
        for (int col = 1; col < dp[0].length; col++) {
            dp[0][col] = dp[0][col-1] + (int) s2.charAt(col-1);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int first = dp[i][j-1] + (int) s2.charAt(j-1);
                    int second = dp[i-1][j] + (int) s1.charAt(i-1);

                    dp[i][j] = Math.min(first, second);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}