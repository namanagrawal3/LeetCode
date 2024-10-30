class Solution {
    public int minScore(int n, int[][] roads) {
        // simply we have to find the minimum weight edge
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            map.get(u).put(v, wt);
            map.get(v).put(u, wt);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(1);
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node])
                continue;

            visited[node] = true;
            
            for (int adjNode : map.get(node).keySet()) {
                if (!visited[adjNode]) {
                    q.add(adjNode);
                    minDist = Math.min(minDist, map.get(node).get(adjNode));
                }
            }
        }
        return minDist;        
    }
}