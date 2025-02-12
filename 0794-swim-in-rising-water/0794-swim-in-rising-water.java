class Solution {
    public int swimInWater(int[][] grid) {
    // We are given 'Source' & 'Destination' with unequal weight edges
    // so, to find the least time use 'Dijkshtra' algorithm

        int n = grid.length;
        int[][] time = new int[n][n];
        for (int[] r : time) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        time[0][0] = grid[0][0];
        pq.add(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int cr = rv[0];
            int cc = rv[1];
            int t = rv[2];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                int tm = t;
                if (grid[nr][nc] > tm)
                    tm = grid[nr][nc];

                if (tm < time[nr][nc]) {
                    time[nr][nc] = tm;
                    pq.add(new int[]{nr, nc, tm});
                }
            }
        }

        return time[n-1][n-1];
    }
}