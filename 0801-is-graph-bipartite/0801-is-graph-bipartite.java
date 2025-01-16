class Solution {
    class Pair {
        int vtx;
        int dis;
        public Pair(int v, int d) {
            vtx = v;
            dis = d;
        }
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();        

        for (int src = 0; src < graph.length; src++) {
            if (visited.containsKey(src))
                continue;
            
            q.add(new Pair(src, 0));
            while (!q.isEmpty()) {
                Pair rv = q.poll();          
                
                if (visited.containsKey(rv.vtx)) {
                    if (visited.get(rv.vtx) != rv.dis) {      // odd-length cycle
                        return false;
                    }  
                    continue;
                }

                visited.put(rv.vtx, rv.dis);  

                for (int nbr : graph[rv.vtx]) {
                    if (!visited.containsKey(nbr))                   
                        q.add(new Pair(nbr, rv.dis+1));
                                       
                }
            }
        }
        return true;
    }
}