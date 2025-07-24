class Solution {
    class Pair {
        int dist;
        int price;
        int row;
        int col;
        public Pair(int d, int p, int r, int c) {
            dist = d;
            price = p;
            row = r;
            col = c;
        }
    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
    // Find the shortest distance of each valid cell from the start using the BFS
    // and store the pairs in a Heap and sort it accordingly and find the top-k pairs
    
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.dist != b.dist)
                    return a.dist - b.dist;
                else if (a.price != b.price)
                    return a.price - b.price;
                else if (a.row != b.row)
                    return a.row - b.row;
                return a.col - b.col;
            }
        });

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(start);
        visited[start[0]][start[1]] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] rv = q.poll();
                int x = rv[0];
                int y = rv[1];
                if (grid[x][y] >= pricing[0] && grid[x][y] <= pricing[1])
                    pq.add(new Pair(level, grid[x][y], x, y));

                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0 || visited[nx][ny])
                        continue;

                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            level++;
        }

        List<List<Integer>> ll = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            Pair rv = pq.poll();
            List<Integer> t = new ArrayList<>();
            t.add(rv.row);
            t.add(rv.col);
            ll.add(t);
        }

        return ll;
    }
}