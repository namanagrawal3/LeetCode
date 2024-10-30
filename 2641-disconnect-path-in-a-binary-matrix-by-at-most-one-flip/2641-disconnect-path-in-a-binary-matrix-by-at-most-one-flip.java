class Solution {
    int[][] dir = {{1,0}, {0,1}};
    public boolean isPossibleToCutPath(int[][] grid) {
        // if two non-intersecting paths exist, then grid can't be disconnected

        // So, first find a valid path and make all 0's in that path and 
        // now if another path exists, then grid can't be disconnected
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        boolean firstPath = checkPath(grid, 0, 0, m, n, dp);
        if (!firstPath)         // already disconnected
            return true;

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        grid[0][0] = 1;         // resetting for secondPath
        boolean secondPath = checkPath(grid, 0, 0, m, n, dp);
        if (secondPath)         // another non-intersecting path exists
            return false;

        return true;
    }
    public  boolean checkPath(int[][] grid, int cr, int cc, int m, int n, int[][] dp) {
        if (cr >= m || cc >= n || grid[cr][cc] == 0)
            return false;

        if (cr == m-1 && cc == n-1)
            return true;

        if (dp[cr][cc] != -1)
            return (dp[cr][cc] == 0) ? false : true;

        grid[cr][cc] = 0;
        for (int i = 0; i < 2; i++) {
            boolean path = checkPath(grid, cr+dir[i][0], cc+dir[i][1], m, n, dp);
            if (path)
                return true;
        }

        grid[cr][cc] = 1;
        dp[cr][cc] = 0;
        return false;        
    }
}