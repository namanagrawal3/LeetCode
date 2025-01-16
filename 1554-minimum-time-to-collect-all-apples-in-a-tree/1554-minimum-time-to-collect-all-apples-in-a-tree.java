class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return timeFun(adj, 0, -1, hasApple);
    }
    public int timeFun(List<List<Integer>> adj, int vtx, int parent, List<Boolean> hasApple) {
        int time = 0;
        for (int nbr : adj.get(vtx)) {
            if (nbr != parent) {
                int temp = timeFun(adj, nbr, vtx, hasApple);
                if (temp > 0 || hasApple.get(nbr))
                    temp += 2;
                
                time += temp;
            }
        }        
        return time;
    }
}