class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = dijkshtra(edges, node1);
        int[] dist2 = dijkshtra(edges, node2);

        int minIdx = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = n-1; i >= 0; i--) {
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE)
                continue;
            int maxDist = Math.max(dist1[i], dist2[i]);
            if (maxDist <= minDist) {
                minIdx = i;
                minDist = maxDist;
            }
        }

        return minIdx;
    }
    public static int[] dijkshtra(int[] edges, int src) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        pq.add(new int[]{src, 0});
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int[] rv = pq.poll();
            int u = rv[0];
            int d = rv[1];
            int nbr = edges[u];
            if (nbr == -1)
                continue;

            if (d+1 < dist[nbr]) {
                dist[nbr] = d+1;
                pq.add(new int[]{nbr, d+1});
            }
        }

        return dist;
    }
}