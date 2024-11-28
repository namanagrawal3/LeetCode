class Solution {
    public int minimumObstacles(int[][] grid) {
        // Clearly, we are given the 'src', 'des' and we have to find the 'min obsc'
        // thus, SSSP will work ,i.e, "Dijkshtra"
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[][] dist = new int[m][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int d = rv[0];
            int cr = rv[1];
            int cc = rv[2];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                if (d + grid[nr][nc] < dist[nr][nc]) {
                    dist[nr][nc] = d + grid[nr][nc];
                    pq.add(new int[]{d+grid[nr][nc], nr, nc});
                }
            }
        }

        return dist[m-1][n-1];
    }
}