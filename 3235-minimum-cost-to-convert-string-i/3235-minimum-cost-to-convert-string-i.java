class Solution {
    public long minimumCost(String src, String target, char[] org, char[] chg, int[] cost) {
        // Using 'dijkshtra' for each unmatched char will give TLE
        // So, we can precompute the min cost for each pair using 'Floyd Warshall'
        
        // Applying Floyd-Warshall
        int[][] dist = new int[26][26];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int u = org[i] - 'a';
            int v = chg[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int u = 0; u < 26; u++) {
                for (int v = 0; v < 26; v++) {
                    if (dist[u][k] != Integer.MAX_VALUE && dist[k][v] != Integer.MAX_VALUE)
                        dist[u][v] = Math.min(dist[u][v], dist[u][k] + dist[k][v]);
                }
            }
        }

        // Calculating the cost to achieve target string
        long ans = 0;
        int n = src.length();
        for (int i = 0; i < n; i++) {
            char sch = src.charAt(i);
            char tch = target.charAt(i);
            if (sch == tch)
                continue;

            if (dist[sch-'a'][tch-'a'] == Integer.MAX_VALUE)
                return -1;

            ans += dist[sch-'a'][tch-'a']; 
        }

        return ans;
    }
}