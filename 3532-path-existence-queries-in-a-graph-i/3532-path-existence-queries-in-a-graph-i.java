class Solution {
    int[] parent;
    int[] rank;

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    // Simple, use the 'Union Find' and check the Components

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n-1; i++) {
            if (nums[i+1] - nums[i] <= maxDiff)
                union(i, i+1);
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            int pu = find(u);
            int pv = find(v);
            ans[i] = (pu == pv);
        }

        return ans;
    }
    public int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return;
        
        if (rank[pu] > rank[pv])
            parent[pv] = pu;
        else if (rank[pu] < rank[pv])
            parent[pu] = pv;
        else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}