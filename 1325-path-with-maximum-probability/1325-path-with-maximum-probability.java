class Solution {
    class Pair {
        double prob;
        int node;
        public Pair(double p, int n) {
            prob = p;
            node = n;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            map.get(u).put(v, p);
            map.get(v).put(u, p);
        }

        double[] prob = new double[n];
        prob[start_node] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override                                       // max-Heap
            public int compare(Pair a, Pair b) {
                return Double.compare(b.prob, a.prob);
            }
        });
        pq.add(new Pair(1, start_node));
        
        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            double p = rv.prob;
            int node = rv.node;
            
            for (int adjNode : map.get(node).keySet()) {
                double pb = map.get(node).get(adjNode);
                if (p * pb > prob[adjNode]) {
                    prob[adjNode] = p * pb;
                    pq.add(new Pair(p * pb, adjNode));
                }
            }            
        }        
        return prob[end_node];
    }
}