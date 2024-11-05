class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // 'BFS' will not work since edge cost is not same for all cells
        // thus, 'Dijkshtra' will work proper
        
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dist = new int[n][m];
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
            int d = rv[0];
            int row = rv[1];
            int col = rv[2];

            for (int i = 0; i < 4; i++) {
                int r = row + dir[i][0];
                int c = col + dir[i][1];
                if (r < 0 || r >= n || c < 0 || c >= m)
                    continue;

                int newDist = -1;
                if (d >= moveTime[r][c])
                    newDist = d + 1;
                else
                    newDist = moveTime[r][c] + 1;

                if (newDist < dist[r][c]) {             // relaxation of edge
                    dist[r][c] = newDist;
                    pq.add(new int[]{newDist, r, c});
                }
            }
        }
        
        return dist[n-1][m-1];
    }
}