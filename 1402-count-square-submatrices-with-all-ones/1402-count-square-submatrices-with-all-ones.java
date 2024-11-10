class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];   
    // dp[i][j] stores the no.of sqr. submatrices having cell(i,j) at bottom right corner

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == 0)
                    dp[i][j] = 0;
                else {
                    int left = dp[i][j-1];
                    int leftDiag = dp[i-1][j-1];
                    int top = dp[i-1][j];

                    dp[i][j] = 1 + Math.min(left, Math.min(leftDiag, top));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                count += dp[i][j];
            }
        }

        return count;
    }
}