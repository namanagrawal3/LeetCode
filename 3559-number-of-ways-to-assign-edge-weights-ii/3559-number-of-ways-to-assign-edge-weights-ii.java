class Solution {
    private List<List<Integer>> adj;
    private int[] dist;
    private int[][] ancestor;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
    // We need to find the distance between 'u' & 'v' efficiently.
    // dist(u, v) = dist(u) + dist(v) - 2*dist(LCA(u, v))
    // thus use 'Binary Lifting' for finding the 'LCA(u, v)' efficiently in O(logn) 

        int n = edges.length + 1;
        int q = queries.length;
        int col = (int) (Math.log(n)/ Math.log(2)) + 1;

        dist = new int[n];
        ancestor = new int[n][col];
        for (int[] r: ancestor) {
            Arrays.fill(r, -1);
        }

        // Building the 'adjacency' list
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e: edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Applying the 'dfs' to find the dist of each node from root & filling the parent
        dfsFun(0, -1);

        // Building the 'ancestor' matrix (jump 2^0 = 1 is already filled in dfs)
        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j-1] != -1)
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
            }
        }

        // Precomputing power of 2
        long mod = 1000000007;
        long[] pow2 = new long[n-1];
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (2 * pow2[i-1]) % mod;
        }

        // Processing for each query now
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1;

            int d = dist[u] + dist[v] - 2 * dist[lcaFun(u, v)];
            ans[i] = (d > 0) ? (int) pow2[d-1] : 0;
        }

        return ans;
    }
    public void dfsFun(int u, int parent) {
        for (int v: adj.get(u)) {
            if (v == parent)
                continue;
            
            dist[v] = dist[u] + 1;
            ancestor[v][0] = u;
            dfsFun(v, u);
        }
    }
    public int lcaFun(int u, int v) {
        if (dist[u] != dist[v]) {       // nodes are at different levels (make them same)
            // assume 'u' is at depth
            if (dist[v] > dist[u]) {
                int temp = u;
                u = v;
                v = temp;
            }

            int k = dist[u] - dist[v];
            u = ancestorFun(u, k);
        }

        if (u == v)
            return u;

        for (int j = ancestor[0].length-1; j >= 0; j--) {
            // if (ancestor[u][j] == -1)
            //     continue;
            if (ancestor[u][j] != ancestor[v][j]) {
                u = ancestor[u][j];
                v = ancestor[v][j];
            }
        }

        return ancestor[u][0];      
    }
    public int ancestorFun(int node, int k) {
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