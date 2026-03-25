class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        // Simply use the 'Prefix-Sum' both vertically & horizontally
        int m = grid.length;
        int n = grid[0].length;

        long total_sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total_sum += grid[i][j];
            }
        }

        if (total_sum % 2 != 0)         // Partition not possible for 'Odd' sum
            return false;
        
        // Checking Horizontally
        long prefRow = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefRow += grid[i][j];
            }

            if (2*prefRow == total_sum)
                return true;
        }

        // Checking vertically
        long prefCol = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                prefCol += grid[i][j];
            }

            if (2*prefCol == total_sum)
                return true;
        }

        return false;
    }
}