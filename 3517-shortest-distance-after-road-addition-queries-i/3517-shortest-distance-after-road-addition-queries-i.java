class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            adj.get(i).add(i+1);
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            adj.get(u).add(v);
            ans[i] = bfsFun(n, adj);
        }

        return ans;
    }
    public static int bfsFun(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int rv = q.poll();
                if (rv == n-1)
                    return level;

                visited[rv] = true;

                for (int adjNode : adj.get(rv)) {
                    if (!visited[adjNode])
                        q.add(adjNode);
                }
            }
            level++;
        }

        return -1;
    }
}