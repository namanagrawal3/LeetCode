class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[m+1][n+1];

        // Creating the prefix-sum array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i-1][j-1] + pre[i][j-1] + pre[i-1][j] - pre[i-1][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lr = Math.max(i-k, 0);
                int lc = Math.max(j-k, 0);
                int ur = Math.min(i+k, m-1);
                int uc = Math.min(j+k, n-1);
                mat[i][j] = pre[ur+1][uc+1] - pre[ur+1][lc] - pre[lr][uc+1] + pre[lr][lc];
            }
        }
        
        return mat;
    }
}