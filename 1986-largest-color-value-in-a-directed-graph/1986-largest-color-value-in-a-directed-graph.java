class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDeg = new int[n];
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            inDeg[v]++;
            adj.get(u).add(v);
        }
        
        int[][] fre = new int[n][26];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
                fre[i][colors.charAt(i)-'a'] = 1;
            }
        }
        
        int ans = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            ans = Math.max(ans, fre[u][colors.charAt(u)-'a']);
            
            for (int v: adj.get(u)) {
                for (int i = 0; i < 26; i++) {
                    fre[v][i] = Math.max(fre[v][i], fre[u][i] + (colors.charAt(v)-'a' == i ? 1 : 0));
                }
                
                inDeg[v]--;
                if (inDeg[v] == 0)
                    q.add(v);
            }
        }
        
        if (cnt < n)
            return -1;
        return ans;
    }
}