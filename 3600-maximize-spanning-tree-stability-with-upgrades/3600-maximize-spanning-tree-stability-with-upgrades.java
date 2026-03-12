class Solution {
    int[] parent, rank;
    public int maxStability(int n, int[][] edges, int k) {
        // We have to maximize the (stability) --> maximize the minimum strength
        // Thus, binary search on answer

        // check whether there is cycle in the edges (m == 1)
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 0);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e: edges) {
            int u = e[0], v = e[1], m = e[3];
            if (m == 0)
                continue;

            int pu = find(u);
            int pv = find(v);
            if (pu == pv)
                return -1;
            union(u, v);
        }

        int si = 1;
        int ei = 200000;            // 2 * 10^5 (can be upgraded)
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(n, edges, k, mid))
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ei == 0 ? -1: ei;
    }
    public boolean isPossible(int n, int[][] edges, int k, int strength) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 0);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<List<Integer>> upgradeCandidate = new ArrayList<>();
        for (int[] e: edges) {
            int u = e[0], v = e[1], s = e[2], m = e[3];
            if (m == 1) {     // must be included in the spanning tree
                if (s < strength)
                    return false;
                union(u, v);
            }
            else {
                if (s >= strength)
                    union(u, v);
                else if (2*s >= strength) {
                    List<Integer> l = new ArrayList<>();
                    l.add(u);
                    l.add(v);
                    upgradeCandidate.add(l);
                }
            }
        }

        for (List<Integer> l: upgradeCandidate) {
            int u = l.get(0);
            int v = l.get(1);
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                continue;
            if (k == 0)
                return false;
            union(u, v);
            k--;            // upgrade
        }

        int root = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != root)
                return false;
        }

        return true;
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