class Solution {
    class Pair {
        int dist;
        int node;
        public Pair(int d, int nn) {
            dist = d;
            node = nn;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            map.get(u).put(v, w);
        }

        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.dist - b.dist;
            }
        });

        pq.add(new Pair(0, k));
        ans[k] = 0;
        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int d = rv.dist;
            int node = rv.node;
            
            for (int adjNode : map.get(node).keySet()) {
                int dist = map.get(node).get(adjNode);
                if (d + dist < ans[adjNode]) {
                    ans[adjNode] = d + dist;
                    pq.add(new Pair(d+dist, adjNode));
                }
            }
        }
        
        int maxTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE)      // means this node is not reachable from node k
                return -1;
            
            maxTime = Math.max(maxTime, ans[i]);
        }
        
        return maxTime;
    }
}