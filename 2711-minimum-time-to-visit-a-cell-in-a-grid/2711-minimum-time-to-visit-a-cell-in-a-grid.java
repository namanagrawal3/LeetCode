class Solution {
    public int minimumTime(int[][] grid) {
        // 'BFS' will not work since edge cost is not same for all cells
        // thus, 'Dijkshtra' will work proper

        if (grid[0][1] > 1 && grid[1][0] > 1)       // we can't oscillate at (0,0) to increase time
            return -1;
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};


        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {      // {dist, row, col}
                return a[0] - b[0];
            }
        });
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int curr_time = rv[0];
            int row = rv[1];
            int col = rv[2];

            for (int i = 0; i < 4; i++) {
                int r = row + dir[i][0];
                int c = col + dir[i][1];
                if (r < 0 || r >= m || c < 0 || c >= n)
                    continue;

                int oscll_time = Math.max(0, grid[r][c] - curr_time - 1);
                if (oscll_time % 2 != 0)
                    oscll_time++;

                if (curr_time + oscll_time + 1 < dist[r][c]) {       // relaxation of edge
                    dist[r][c] = curr_time + oscll_time + 1;
                    pq.add(new int[]{curr_time + oscll_time + 1, r, c});
                }
            }
        }
        
        return dist[m-1][n-1];
    }
}