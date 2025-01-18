class Solution {
    class Pair {
        int row;
        int col;
        int cost;
        public Pair(int r, int c, int cost) {
            row = r;
            col = c;
            this.cost = cost;
        }
    }
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.cost - b.cost;
            }
        });

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int cr = rv.row;
            int cc = rv.col;
            int cost = rv.cost;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int c = (i == grid[cr][cc]-1) ? 0 : 1;
                if (cost + c < dist[nr][nc]) {
                    dist[nr][nc] = cost + c;
                    pq.add(new Pair(nr, nc, cost+c));
                }
            }
        }

        return dist[m-1][n-1];
    }
}