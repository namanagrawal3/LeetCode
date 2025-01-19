class Solution {
    class Pair {
        int height;
        int row;
        int col;
        public Pair(int h, int r, int c) {
            height = h;
            row = r;
            col = c;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.height - b.height;
            }
        });
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    pq.add(new Pair(heightMap[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }

        int water = 0;
        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int h = rv.height;
            int cr = rv.row;
            int cc = rv.col;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
                    continue;

                water += Math.max(0, h - heightMap[nr][nc]);

                pq.add(new Pair(Math.max(h, heightMap[nr][nc]), nr, nc));
                visited[nr][nc] = true;
            }
        }

        return water;
    }
}