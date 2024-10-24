class Solution {
    public int minDistance(String word1, String word2) {
        // same problem as 'Edit Distance'
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int row = 1; row < dp.length; row++) {         // base-case
            dp[row][0] = row;
        }
        for (int col = 1; col < dp[0].length; col++) {
            dp[0][col] = col;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}