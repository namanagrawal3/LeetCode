class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;

        int n = grid.length;
        int[] r = {0,1,1,1,0,-1,-1,-1};
        int[] c = {1,1,0,-1,-1,-1,0,1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] rv = q.poll();
                int X = rv[0];
                int Y = rv[1];

                if (X == n-1 && Y == n-1)
                    return level+1;

                for (int i = 0; i < 8; i++) {
                    int x = X + r[i];
                    int y = Y + c[i];
                    
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1)
                        continue;

                    q.add(new int[]{x, y});
                    grid[x][y] = 1;             // mark as visited
                }
            }
            level++;
        }
        return -1;
    }
}