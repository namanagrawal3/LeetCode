class Solution {
    public boolean hasValidPath(int[][] grid) {
    // Simply, use the DFS to check the path using the direction map

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        HashMap<Integer, int[][]> dirMap = new HashMap<>();
        dirMap.put(1, new int[][] {{0, -1}, {0, 1}});
        dirMap.put(2, new int[][] {{-1, 0}, {1, 0}});
        dirMap.put(3, new int[][] {{0, -1}, {1, 0}});
        dirMap.put(4, new int[][] {{0, 1}, {1, 0}});
        dirMap.put(5, new int[][] {{-1, 0}, {0, -1}});
        dirMap.put(6, new int[][] {{-1, 0}, {0, 1}});

        return dfsFun(grid, visited, m, n, 0, 0, dirMap);
    }
    public boolean dfsFun(int[][] grid, boolean[][] visited, int m, int n, int cr, int cc, HashMap<Integer, int[][]> dirMap) {
        if (cr == m-1 && cc == n-1)
            return true;

        visited[cr][cc] = true;
        int street = grid[cr][cc];

        for (int[] dir: dirMap.get(street)) {
            int nr = cr + dir[0];
            int nc = cc + dir[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
                continue;

            for (int[] backDir: dirMap.get(grid[nr][nc])) {
                if (nr + backDir[0] == cr && nc + backDir[1] == cc) {
                    if (dfsFun(grid, visited, m, n, nr, nc, dirMap))
                        return true;
                }
            }
        }

        return false;
    } 
}