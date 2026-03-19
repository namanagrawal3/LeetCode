class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        // Use the "Prefix Sum" in 2D array (Same as Leetcode - 3070)
        // Store the freq of X & Y using prefix technique

        int m = grid.length;
        int n = grid[0].length;

        int[][] freX = new int[m][n];
        int[][] freY = new int[m][n];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                freX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                freY[i][j] = (grid[i][j] == 'Y') ? 1 : 0;
                
                if (i-1 >= 0) {
                    freX[i][j] += freX[i-1][j];
                    freY[i][j] += freY[i-1][j];
                }

                if (j-1 >= 0) {
                    freX[i][j] += freX[i][j-1];
                    freY[i][j] += freY[i][j-1];
                }

                if (i-1 >= 0 && j-1 >= 0) {
                    freX[i][j] -= freX[i-1][j-1];
                    freY[i][j] -= freY[i-1][j-1];
                }

                if (freX[i][j] == freY[i][j] && freX[i][j] > 0)
                    cnt++;
            }
        }

        return cnt;
    }
}