class Solution {
    int[] parent;
    int[] rank;
    
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            if (find(u) == find(v))
                continue;
            union(u, v);
        }

        // Stores no. of edges in a component
        HashMap<Integer, Integer> edgeMap = new HashMap<>();
        for (int[] e : edges) {
            int p = find(e[0]);
            edgeMap.put(p, edgeMap.getOrDefault(p, 0) + 1);
        }

        // Stores no. of nodes in a component
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i);
            nodeMap.put(p, nodeMap.getOrDefault(p, 0) + 1);
        }

        int count = 0;
        for (int p : nodeMap.keySet()) {
            int nodes = nodeMap.get(p);
            if (!edgeMap.containsKey(p) && nodes == 1)
                count++;
            else if (edgeMap.containsKey(p) && edgeMap.get(p) == (nodes * (nodes-1))/2)
                count++;
        }

        return count;
    }
    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return;

        if (rank[px] > rank[py])
            parent[py] = px;
        else if (rank[px] < rank[py])
            parent[px] = py;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}