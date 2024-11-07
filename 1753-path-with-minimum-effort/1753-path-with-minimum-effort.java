class Solution {
    public int minimumEffortPath(int[][] heights) {
        // since, edge costs are not same, thus 'Dijkshtra' will work
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int effort = rv[0];
            int row = rv[1];
            int col = rv[2];

            for (int i = 0; i < 4; i++) {
                int r = row + dir[i][0];
                int c = col + dir[i][1];
                if (r < 0 || r >= m || c < 0 || c >= n)
                    continue;

                int maxEffort = Math.max(effort, Math.abs(heights[r][c] - heights[row][col]));

                if (maxEffort < dist[r][c]) {
                    dist[r][c] = maxEffort;
                    pq.add(new int[]{maxEffort, r, c});
                }
            }
        }
        return dist[m-1][n-1];
    }
}