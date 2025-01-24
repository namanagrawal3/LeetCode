class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // nodes that form a cycle will never be the safe nodes
        
        // we will check the cycle nodes using Topological Sort
        // and to perform that we need to reverse the graph here  

        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {               // reversing graph 
            for (int ele : graph[i]) {
                adj.get(ele).add(i);
            } 
        }

        int[] inDeg = new int[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            inDeg[i] = graph[i].length;               
        }
        
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            ans.add(rv);

            for (int nbrs : adj.get(rv)) {
                inDeg[nbrs]--;
                if (inDeg[nbrs] == 0)
                    q.add(nbrs);
            }
        }

        Collections.sort(ans);        
        return ans;
    }
}