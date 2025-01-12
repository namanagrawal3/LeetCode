class Solution {
    public class Pair {
        int row;
        int col;
        int dist;
        public Pair(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }
    public int[][] highestPeak(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new ArrayDeque<>();

        int[] r = {0, 1, 0, -1};
        int[] c = {1, 0, -1, 0};              

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair rv = q.poll();
            int cr = rv.row;
            int cc = rv.col;
            int d = rv.dist;

            if (mat[cr][cc] == 0)
                ans[cr][cc] = d;

            for (int i = 0; i < 4; i++) {
                int nr = cr + r[i];
                int nc = cc + c[i];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                if (!visited[nr][nc]) {
                    q.add(new Pair(nr, nc, d+1));
                    visited[nr][nc] = true;
                }
            }
        }

        return ans;
    }
}