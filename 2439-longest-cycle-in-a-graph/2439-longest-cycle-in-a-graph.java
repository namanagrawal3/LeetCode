class Solution {
    public int longestCycle(int[] edges) {
    // In Topological Sort, nodes that are not added in the queue will be the part of cycle
    // but, there can be multiple cycles (multiple components)
    // so, we need to traverse all the components also 

        int n = edges.length;
        int[] inDeg = new int[n];

        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];
            if (v == -1)
                continue;
            inDeg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;
        while (!q.isEmpty()) {
            int rv = q.poll();
            cnt++;
            visited[rv] = true;

            int nbr = edges[rv];
            if (nbr == -1)
                continue;

            inDeg[nbr]--;
            if (inDeg[nbr] == 0)
                q.add(nbr);
        }

        if (cnt == n)
            return -1;

        int maxLen = -1;
        for (int src = 0; src < n; src++) {
            if (visited[src])
                continue;
            
            int len = 1;
            visited[src] = true;
            int nxt = edges[src];
            while (nxt != src) {
                len++;
                visited[nxt] = true;
                nxt = edges[nxt];
            }

            maxLen = Math.max(maxLen, len);            
        }

        return maxLen;
    }
}