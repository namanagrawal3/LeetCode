class Solution {
    int[] parent;
    int[] rank;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int r = requests.length;
        boolean[] ans = new boolean[r];

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < r; i++) {
            int[] req = requests[i];
            int u = findParent(req[0]);
            int v = findParent(req[1]);
            boolean flag = true;

            for (int[] res : restrictions) {
                int x = findParent(res[0]);
                int y = findParent(res[1]);
                
                if ((u == x && v == y) || (u == y && v == x)) {
                    flag = false;
                    break;
                }
            }
            
            ans[i] = flag;
            if (flag)
                union(u, v);
        }

        return ans;
    }
    public int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px == py)
            return;

        if (rank[px] == rank[py]) {
            parent[py] = px;
            rank[px]++;
        }
        else if (rank[px] > rank[py])
            parent[py] = px;
        else
            parent[px] = py;        
    }
}