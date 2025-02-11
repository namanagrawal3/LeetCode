class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        Queue<int[]> q = new ArrayDeque<>();
        int freshOrg = 0;
        int minutes = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    freshOrg++;
                else if (grid[i][j] == 2) 
                    q.add(new int[]{i, j});
            }
        }

        if (freshOrg == 0)
            return 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] rv = q.poll();
                int cr = rv[0];
                int cc = rv[1];
                
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dir[i][0];
                    int nc = cc + dir[i][1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;
                    if (grid[nr][nc] == 1) {
                        freshOrg--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        
        if (freshOrg != 0)
            return -1;
        return minutes-1;
    }
}