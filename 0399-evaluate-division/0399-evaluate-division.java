class Solution {
    public class Pair {
        String node;
        double d;
        public Pair(double dist, String nn) {
            d = dist;
            node = nn;
        }
    }
    public double[] calcEquation(List<List<String>> equ, double[] val, List<List<String>> query) {
        // treat the equations as the directed edges with values as weights
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        int n = query.size();
        
        for (int i = 0; i < val.length; i++) {
            String u = equ.get(i).get(0);
            String v = equ.get(i).get(1);

            if (!map.containsKey(u))
                map.put(u, new HashMap<>());
            if (!map.containsKey(v))
                map.put(v, new HashMap<>());

            map.get(u).put(v, val[i]);
            map.get(v).put(u, 1/val[i]);
        }

        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            String src = query.get(i).get(0); 
            String des = query.get(i).get(1); 

            if (!map.containsKey(src) || !map.containsKey(des)) 
                ans[i] = -1;            
            else if (src.equals(des)) 
                ans[i] = 1;
            else 
                ans[i] = pathFun(src, des, map);
        }

        return ans;
    }
    public double pathFun(String src, String des, HashMap<String, HashMap<String, Double>> map) {
        HashMap<String, Double> dist = new HashMap<>();
        dist.put(src, 1.0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return Double.compare(a.d, b.d);
            }
        });
        pq.add(new Pair(1.0, src));

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            String node = rv.node;
            double d = rv.d;

            for (String adjNode : map.get(node).keySet()) {
                double cost = map.get(node).get(adjNode);
                if (!dist.containsKey(adjNode) || dist.get(adjNode) > cost * d) {
                    dist.put(adjNode, cost * d);
                    pq.add(new Pair(cost * d, adjNode));
                }
            }
        }

        if (dist.containsKey(des))
            return dist.get(des);
        return -1;
    }
}