class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // since, edge cost are not same thus, dijkshtra for the shortest path
        
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] dist = new int[n][m];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {    //{dist, row, col, 1/0}
                return a[0] - b[0];
            }
        });
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0, 0});                // 0 -> 1 sec, 1 -> 2 sec

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int d = rv[0];
            int row = rv[1];
            int col = rv[2];
            int sec = rv[3];
            
            for (int i = 0; i < 4; i++) {
                int r = row + dir[i][0];
                int c = col + dir[i][1];
                if (r < 0 || r >= n || c < 0 || c >= m)
                    continue;
                
                int newDist = sec + 1;
                if (d >= moveTime[r][c])
                    newDist += d;
                else 
                    newDist += moveTime[r][c];
                
                if (newDist < dist[r][c]) {         // relaxation
                    dist[r][c] = newDist;
                    pq.add(new int[]{newDist, r, c, 1-sec});
                }
            }
        }
        return dist[n-1][m-1];
    }
}