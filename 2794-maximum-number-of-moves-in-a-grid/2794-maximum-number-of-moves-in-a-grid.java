class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int j = n-2 ; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                int top = 0;
                int mid = 0;
                int bottom = 0;

                if (i-1 >= 0 && grid[i-1][j+1] > grid[i][j]) 
                    top = dp[i-1][j+1] + 1;

                if (grid[i][j+1] > grid[i][j]) 
                    mid = dp[i][j+1] + 1;

                if (i+1 < m && grid[i+1][j+1] > grid[i][j]) 
                    bottom = dp[i+1][j+1] + 1; 

                dp[i][j] = Math.max(top, Math.max(mid, bottom));               
            }
        }

        int moves = 0;
        for (int i = 0; i < m; i++) {
            if (dp[i][0] > moves)
                moves = dp[i][0];
        }

        return moves;
    }
}