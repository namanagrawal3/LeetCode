class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
    // Maximum nodes for tree-2 will be fixed
    // thus, they can be precomputed and finally add them to each node
    
        int n = edges1.length;
        int m = edges2.length;
        List<List<Integer>> adj1 = createGraph(edges1);
        List<List<Integer>> adj2 = createGraph(edges2);

        int maxNodes = 0;
        for (int i = 0; i <= m; i++) {
            int nodes = dfsFun(i, -1, adj2, k-1);
            maxNodes = Math.max(maxNodes, nodes);
        }

        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = dfsFun(i, -1, adj1, k) + maxNodes;
        }

        return ans;

    }
    public static List<List<Integer>> createGraph(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
    public static int dfsFun(int u, int parent, List<List<Integer>> adj, int k) {
        if (k < 0)
            return 0;

        int cnt = 1;
        for (int v : adj.get(u)) {
            if (v == parent)
                continue;
            cnt += dfsFun(v, u, adj, k-1);
        }

        return cnt;
    }
}