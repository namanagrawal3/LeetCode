class Solution {
    public int countPaths(int n, int[][] roads) {
    // Simple Dijkshtra (SSSP) is applied

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int[] road: roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            map.get(u).put(v, wt);
            map.get(v).put(u, wt);
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        pq.add(new int[]{0, 0});
        dist[0] = 0;
        ways[0] = 1;
        int mod = 1000000007;

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int u = rv[0];
            long d = rv[1];
            
            for (int nbr : map.get(u).keySet()) {
                int currD = map.get(u).get(nbr);
                if (d + currD < dist[nbr]) {
                    dist[nbr] = d + currD;
                    pq.add(new int[]{nbr, (int)d+currD});
                    ways[nbr] = ways[u];
                }
                else if (d + currD == dist[nbr]) 
                    ways[nbr] = (ways[nbr] + ways[u]) % mod;
            }
        }
        
        return ways[n-1];    
    }
}