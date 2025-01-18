class Solution {
    public int longestIncreasingPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dp = new int[m][n];
        
    // for each cell grid[i][j], we will find the length of L.I.P ending at (i,j)
        int maxLen = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = pathFun(grid, i, j, dir, dp);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
    public int pathFun(int[][] grid, int cr, int cc, int[][] dir, int[][] dp) {
        if (dp[cr][cc] != 0)
            return dp[cr][cc];

        int max = 0;                           
        for (int i = 0; i < 4; i++) {
            int nr = cr + dir[i][0];
            int nc = cc + dir[i][1];
            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] >= grid[cr][cc])
                continue;

            int len = pathFun(grid, nr, nc, dir, dp);
            max = Math.max(max, len);
        }

        return dp[cr][cc] = max + 1; 
    }
}