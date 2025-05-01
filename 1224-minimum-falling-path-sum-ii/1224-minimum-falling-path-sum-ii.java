class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int minVal = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j)
                        continue;
                    minVal = Math.min(minVal, dp[i+1][k]);
                }

                dp[i][j] = minVal + matrix[i][j];
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}