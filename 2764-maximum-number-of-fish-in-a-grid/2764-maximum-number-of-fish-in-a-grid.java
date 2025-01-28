class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    // mark visited water cell as -1
                    int fistCount = markWaterCellVisited(grid, i, j, m, n);                 
                    maxFish = Math.max(maxFish, fistCount);
                }
            }
        }

        return maxFish;
    }
    public int markWaterCellVisited(int[][] grid, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] <= 0)
            return 0;

        int count = grid[x][y];
        grid[x][y] = -1;

        int[] r = {0,-1,0,1};
        int[] c = {1,0,-1,0};

        for (int i = 0; i < 4; i++) {
            count += markWaterCellVisited(grid, x+r[i], y+c[i], row, col);
        }
        
        return count;
    }
}