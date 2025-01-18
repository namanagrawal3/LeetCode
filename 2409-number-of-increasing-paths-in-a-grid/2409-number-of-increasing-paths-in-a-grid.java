class Solution {
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dp = new int[m][n];
        
    // for each cell grid[i][j], we will find the no. of Inc. paths ending at (i,j)
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += countPath(grid, m, n, i, j, dir, dp);
                ans %= mod;
            }
        }

        return ans;
    }
    public int countPath(int[][] grid, int m, int n, int cr, int cc, int[][] dir, int[][] dp) {
        if (dp[cr][cc] != 0)
            return dp[cr][cc];

        int count = 1;                    // single cell is also an inc. path       
        for (int i = 0; i < 4; i++) {
            int nr = cr + dir[i][0];
            int nc = cc + dir[i][1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] >= grid[cr][cc])
                continue;

            count += countPath(grid, m, n, nr, nc, dir, dp) % mod;
            count %= mod;
        }

        return dp[cr][cc] = count;
    }
}