class Solution {
    int[] parent;
    int[] rank;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    // Simply use the DSU and for each component, store the elements with their freq

        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        
        // Performing the Union 
        for (int[] swap: allowedSwaps) {
            int a = swap[0];
            int b = swap[1];
            if (find(a) != find(b))
                union(a, b);
        }

        // Storing the elements for each component
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            if (!map.containsKey(parent))
                map.put(parent, new HashMap<>());

            HashMap<Integer, Integer> Elements = map.get(parent);
            Elements.put(source[i], Elements.getOrDefault(source[i], 0)+1);
        }

        // Checking the diff elements
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int parent = find(i);
            HashMap<Integer, Integer> Elements = map.get(parent);
            if (Elements.containsKey(target[i]) && Elements.get(target[i]) > 0) {
                Elements.put(target[i], Elements.get(target[i])-1);
                continue;
            }
            diff++;
        }

        return diff;
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
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}