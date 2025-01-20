class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];
        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    row[i]--;
                    col[j]--;
                }
                else {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = row[i] + col[j];
            }
        }

        return diff;
    }
}