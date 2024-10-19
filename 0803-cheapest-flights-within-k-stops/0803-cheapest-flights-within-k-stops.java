class Solution {
    class Pair {
        int dist;
        int node;
        public Pair(int d, int nn) {
            dist = d;
            node = nn;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] e : flights) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            map.get(u).put(v, w);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, src));
        dist[src] = 0;
        int level = 0;
    
        while (!q.isEmpty() && level <= k) {
            int size = q.size();
            while (size-- > 0) {
                Pair rv = q.poll();
                int d = rv.dist;
                int node = rv.node;

                for (int adjNode : map.get(node).keySet()) {
                    int dt = map.get(node).get(adjNode);
                    if (d + dt < dist[adjNode]) {
                        dist[adjNode] = d + dt;                    
                        q.add(new Pair(d+dt, adjNode));
                    }
                }
            }
            level++;
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}