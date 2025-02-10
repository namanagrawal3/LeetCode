class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[n+1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] r : relations) {
            int u = r[0];
            int v = r[1];
            adj.get(u).add(v);
            inDeg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] maxTime = new int[n+1];           // stores the max-time to complete each course

        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
                maxTime[i] = time[i-1];
            }
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            for (int nbr : adj.get(rv)) {
                inDeg[nbr]--;
                if (inDeg[nbr] == 0)
                    q.add(nbr);
            
            // we will update the max-time for each nbr starting from each node 
                maxTime[nbr] = Math.max(maxTime[nbr], time[nbr-1]+maxTime[rv]);
            }
        }

        int max = 0;
        for (int t : maxTime) {
            max = Math.max(max, t);
        }
        
        return max;
    }
}