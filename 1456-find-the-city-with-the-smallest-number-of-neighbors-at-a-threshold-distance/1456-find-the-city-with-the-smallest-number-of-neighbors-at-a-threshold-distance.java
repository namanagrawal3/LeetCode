class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)                 // dist[i,i] = 0
                    continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {       // Floyd-Warshall
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCity = -1;
        int connCity = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[city][j] != 0 && dist[city][j] <= distanceThreshold)
                    count++;
            }
            
            if (count <= connCity) {
                connCity = count;
                minCity = city;
            }
        }
        return minCity;
    }
}