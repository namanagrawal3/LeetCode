class Solution {
    int[] parent;
    int[] cost;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
    // AND (Cost) always decreases on increasing the no. of edges
    // So, we will store the AND of each edge of a component in it's parent node 

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        cost = new int[n];                 // x & (-1) = x
        Arrays.fill(cost, -1);

        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            union(u, v, w);
        }

        int[] ans = new int[query.length];
        int idx = 0;
        for (int[] q: query) {
            int si = q[0];
            int ti = q[1];
            
            if (si == ti)                   
                ans[idx++] = 0;
            else if (find(si) == find(ti))      
                ans[idx++] = cost[find(si)];
            else                           // start & target belong to different components 
                ans[idx++] = -1;
        }

        return ans;
    }
    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y, int wt) {
        int px = find(x);
        int py = find(y);

        parent[py] = px;
        cost[px] = cost[px] & cost[py] & wt;
    }
}