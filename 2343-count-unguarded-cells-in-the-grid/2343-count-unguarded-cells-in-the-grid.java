class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // Guard --> 1, Wall --> 2, Occupy --> -1

        for (int[] g : guards) {        // marking the cells as 'guard' or 'wall'
            grid[g[0]][g[1]] = 1;
        } 
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        for (int[] g : guards) {       // checking for each guard
            int cr = g[0];
            int cc = g[1];
            
            // top
            int r = cr-1;
            while (r >= 0) {
                if (grid[r][cc] == 1 || grid[r][cc] == 2)
                    break;
                grid[r][cc] = -1;
                r--;
            }

            // bottom
            r = cr+1;
            while (r < m) {
                if (grid[r][cc] == 1 || grid[r][cc] == 2)
                    break;
                grid[r][cc] = -1;
                r++;
            }

            // left
            int c = cc-1;
            while (c >= 0) {
                if (grid[cr][c] == 1 || grid[cr][c] == 2)
                    break;
                grid[cr][c] = -1;
                c--;
            }

            // right
            c = cc+1;
            while (c < n) {
                if (grid[cr][c] == 1 || grid[cr][c] == 2)
                    break;
                grid[cr][c] = -1;
                c++;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    count++;
            }
        }

        return count;
    }
}