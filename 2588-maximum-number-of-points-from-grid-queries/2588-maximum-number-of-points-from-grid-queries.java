class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;

        int[][] query = new int[k][2];
        for (int i = 0; i < k; i++) {
            query[i][0] = i;
            query[i][1] = queries[i];
        }
        
        Arrays.sort(query, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] visited = new boolean[m][n];
        int[] ans = new int[k];

        int points = 0;
        pq.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        for (int i = 0; i < k; i++) {
            int q = query[i][1];
            int idx = query[i][0];

            while (!pq.isEmpty() && pq.peek()[0] < q) {
                int[] rv = pq.poll();
                int cr = rv[1];
                int cc = rv[2];

                points++;

                for (int j = 0; j < 4; j++) {
                    int nr = cr + dir[j][0];
                    int nc = cc + dir[j][1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
                        continue;

                    pq.add(new int[]{grid[nr][nc], nr, nc});
                    visited[nr][nc] = true;
                }
            }
            
            ans[idx] = points;
        }

        return ans;
    }
}