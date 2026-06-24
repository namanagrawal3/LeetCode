class TreeAncestor {
// Application of 'Binary Lifting' on tree (DP on Trees)
    private int row;
    private int col;
    private int[][] ancestor;

    public TreeAncestor(int n, int[] parent) {
        row = n;
        col = (int) (Math.log(n) / Math.log(2)) + 1; // Way to find log2(n) in java
        
        ancestor = new int[row][col];
        for (int[] r: ancestor) {
            Arrays.fill(r, -1);
        }

        // Building the 'ancestor' matrix
        for (int node = 0; node < row; node++) {     // Filling the parent (2^0 jump)
            ancestor[node][0] = parent[node];
        }

        for (int j = 1; j < col; j++) {
            for (int node = 0; node < row; node++) {
                if (ancestor[node][j-1] != -1)
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < col; j++) {         // Expressing 'K' as sum of 'Powers of 2'
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];
                if (node == -1)
                    break;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */