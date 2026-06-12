class Solution {
    int mod = 1000000007;

    public int assignEdgeWeights(int[][] edges) {
    // Simply, for max-height 'h' (say h = 5), total ways = 5C1 + 5C3 + 5C5 = 2^(5-1) "Sum of odd binomial coefficients"

        // First, build tree (adjacency list) to find the 'h'
        int n = edges.length + 1;
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

        // Finding the height through BFS 
        int h = maxHeight(adj, n);
        return (int) powFun(2, h-1);
    }
    public int maxHeight(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        int level = 0;
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.poll();
                for (int v: adj.get(u)) {
                    if (!visited[v]) {
                        q.add(v);
                        visited[v] = true;
                    }
                }
            }
            level++;
        }

        return level-1;
    }
    public long powFun(int a, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return a;

        long ans = powFun(a, n/2) % mod;
        ans = (ans * ans) % mod;
        if (n % 2 == 1) 
            ans *= a;

        return ans % mod;
    }
}