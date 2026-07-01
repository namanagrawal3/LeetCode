class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
    // We need to just find the "dist(a,b) + 1" for each query [a, b], which can be efficiently find using the 'Binary Lifting'
    // But we can't build the 'ancestor' matrix and iterate also because there are so many nodes (2^30), will give the 'MLE' & 'TLE'
    // Thus, use the properties of the 'Complete Binary Tree'

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lcaFun(n, u, v);
            int dist = distFun(u) + distFun(v) - 2 * distFun(lca);
            ans[i] = dist + 1; 
        }

        return ans;     
    }
    public int distFun(int node) {
    // Finds the distance of node from the root (Can't apply the DFS)
        // int edge = 0;
        // while (node != 1) {
        //     node /= 2;      // finding the parent
        //     edge++;
        // } 
        // return edge;

        return (int) (Math.log(node)/ Math.log(2));
    }
    public int lcaFun(int n, int u, int v) {
        if (distFun(u) != distFun(v)) {
            if (distFun(v) > distFun(u)) {
                int temp = u;
                u = v;
                v = temp;
            }

            int k = distFun(u) - distFun(v);
            u = getKthAncestor(u, k);
        }

        if (u == v)
            return u;

        int col = (int) (Math.log(n)/ Math.log(2));
        for (int j = col; j >= 0; j--) {
            if (getKthAncestor(u, (1 << j)) != getKthAncestor(v, (1 << j))) {
                u = getKthAncestor(u, (1 << j));
                v = getKthAncestor(v, (1 << j));
            }
        }

        return getKthAncestor(u, 1);
    }
    public int getKthAncestor(int node, int k) {
        // while (k-- > 0) {
        //     node /= 2;
            // if (node == 0)
            //     break;
        // }
        // return node;

        node = node >> k;
        return node; 
    }
}