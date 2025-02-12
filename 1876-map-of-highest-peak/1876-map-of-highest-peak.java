class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new ArrayDeque<>();
        int[][] height = new int[m][n];
        for (int[] r : height) {
            Arrays.fill(r, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] rv = q.poll();
            int cr = rv[0];
            int cc = rv[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || height[nr][nc] != -1)
                    continue;
                
                height[nr][nc] = height[cr][cc] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        
        return height;
    }
}