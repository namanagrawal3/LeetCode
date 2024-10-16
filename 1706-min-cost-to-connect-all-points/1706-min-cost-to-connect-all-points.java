class Solution {
    class Pair {
        int des;
        int cost;                    // simple 'Minimum Cost Spanning Tree' problem
        public Pair(int d, int c) {     
            des = d;
            cost = c;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int u = 0; u < n; u++) {
            for (int v = u+1; v < n; v++) {
                int cost = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                map.get(u).put(v, cost);
                map.get(v).put(u, cost);
            }
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.cost - b.cost;
            }
        });

        int sum = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int u = rv.des;
            if (visited[u])
                continue;

            sum += rv.cost;
            visited[u] = true;
            for (int v : map.get(u).keySet()) {
                if (visited[v] == false) {
                    pq.add(new Pair(v, map.get(u).get(v)));
                }
            }
        }

        return sum;
    }
}