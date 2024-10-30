class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {           // not visited
                    boolean cycle = checkFun(grid, i, j, -1, -1, m, n, grid[i][j], visited);
                    if (cycle) 
                        return true;                        
                }
            }
        }
        return false;
    }
    public boolean checkFun(char[][] grid, int cr, int cc, int pr, int pc, int m, int n, char ch, boolean[][] visited) {
        if (cr < 0 || cr >= m || cc < 0 || cc >= n || grid[cr][cc] != ch)
            return false;

        if (visited[cr][cc])
            return true;

        visited[cr][cc] = true;         // mark as visited

        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};
        for (int i = 0; i < 4; i++) {
            if (cr+r[i] == pr && cc+c[i] == pc) 
                continue;
            boolean ans = checkFun(grid, cr+r[i], cc+c[i], cr, cc, m, n, ch, visited);
            if (ans)
                return true;
        }
        return false;
    }
}