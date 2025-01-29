class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);

        for (int[] e : edges) {
            int p1 = findParent(e[0]);
            int p2 = findParent(e[1]);
            if (p1 != p2)
                union(p1, p2);
            else
                return e;
        }
        return new int[]{};
    }
    public int findParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }
    public void union(int x, int y) {
        int parent_x = findParent(x);
        int parent_y = findParent(y);

        if (parent_x == parent_y)
            return;

        if (rank[parent_x] > rank[parent_y])
            parent[parent_y] = parent_x;
        else if (rank[parent_x] < rank[parent_y])
            parent[parent_x] = parent_y;
        else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }
}