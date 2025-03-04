class Solution {
    public int maximumDetonation(int[][] bombs) {
    // We can detonate only 1 bomb so we will check 
    // how many bombs can be detonated from each bomb 

        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (u == v)
                    continue;
                if (canDetonate(bombs[u], bombs[v]))
                    adj.get(u).add(v);
            }
        }

        int maxBombs = 0;
        for (int i = 0; i < n; i++) {
            int bomb = bfsFun(adj, i);
            maxBombs = Math.max(maxBombs, bomb);
        }

        return maxBombs;
    }
    public boolean canDetonate(int[] bomb1, int[] bomb2) {
        long x = bomb2[0] - bomb1[0];
        long y = bomb2[1] - bomb1[1];
        long d = x*x + y*y;
        return d <= 1L*bomb1[2]*bomb1[2];
    }
    public int bfsFun(List<List<Integer>> adj, int src) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);

        while (!q.isEmpty()) {
            int rv = q.poll();
            if (visited.contains(rv)) 
                continue;
            visited.add(rv);

            for (int nbr : adj.get(rv)) {
                if (!visited.contains(nbr))
                    q.add(nbr);
            }
        }

        return visited.size();    
    }
}