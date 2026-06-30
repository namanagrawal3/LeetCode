class Solution {
    private List<HashMap<Integer, Integer>> adj;
    private int[] dist;
    private int[][] ancestor;
    private int[][] freq;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
    // For each query (u, v), we need to find the dist(u, v) - maxFre(path from u to v)
    // For finding the path efficiently, use 'Binary Lifting' concept

        int col = (int) (Math.log(n)/ Math.log(2)) + 1; 
        dist = new int[n];
        ancestor = new int[n][col];
        for (int[] a: ancestor) {
            Arrays.fill(a, -1);
        }
        
        // 'freq' stores the freq of each 'wt' for each node from the root (complete path)
        // freq(u, v) will be calculated similar to dist(u, v) 
        freq = new int[n][27];

        // Build the 'adjacency' list
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashMap<>());
        }

        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).put(v, w);
            adj.get(v).put(u, w);
        }

        // Apply the 'DFS' to fill the 'dist','ancestor' & 'freq' (assume '0' as the root) 
        dfsFun(0, -1, 0);

        // Fill the 'ancestor' array
        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j-1] != -1)
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lcaFun(u, v);
            int d = dist[u] + dist[v] - 2 * dist[lca];

            int maxFre = 0;
            for (int k = 1; k <= 26; k++) {
                int fre = freq[u][k] + freq[v][k] - 2 * freq[lca][k];
                maxFre = Math.max(maxFre, fre);
            }

            ans[i] = d - maxFre;
        }

        return ans;
    }
    public void dfsFun(int u, int prev, int level) {
        HashMap<Integer, Integer> map = adj.get(u);
        for (int v: map.keySet()) {
            if (v == prev)
                continue;
            dist[v] = level+1;
            ancestor[v][0] = u;

            // First copy the parent's freq then increment it
            for (int k = 1; k <= 26; k++) {
                freq[v][k] = freq[u][k];
            }
            int w = map.get(v);  
            freq[v][w]++;
            dfsFun(v, u, level+1);
        }
    }
    public int lcaFun(int u, int v) {
        if (dist[u] != dist[v]) {
            if (dist[u] < dist[v]) {    // assume, 'u' will always at depth
                int temp = u;
                u = v;
                v = temp;
            }

            int k = dist[u] - dist[v];
            u = getKthAncestor(u, k);
        }

        if (u == v)
            return u;

        for (int j = ancestor[0].length-1; j >= 0; j--) {
            if (ancestor[u][j] != ancestor[v][j]) {
                u = ancestor[u][j];
                v = ancestor[v][j];
            }
        }

        return ancestor[u][0];
    }
    public int getKthAncestor(int node, int k) {
        int col = ancestor[0].length;
        for (int j = 0; j < col; j++) {
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];
                if (node == -1)
                    break;
            }
        }
        return node;
    }
}