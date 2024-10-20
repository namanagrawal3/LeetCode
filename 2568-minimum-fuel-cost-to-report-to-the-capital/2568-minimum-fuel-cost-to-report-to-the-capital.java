class Solution {
    long cost;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = roads.length + 1;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        cost = 0;
        dfsFun(adj, 0, seats, visited);
        return cost;
    }
    public int dfsFun(List<List<Integer>> adj, int u, int seats, boolean[] visited) {
        visited[u] = true;
        int people = 1;

        for (int v : adj.get(u)) {
            if (!visited[v])
                people += dfsFun(adj, v, seats, visited);
        }

        if (u > 0) 
            cost += (long) Math.ceil(people/(double)seats);
        
        return people;
    }
}