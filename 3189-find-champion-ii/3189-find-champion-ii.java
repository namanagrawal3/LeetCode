class Solution {
    public int findChampion(int n, int[][] edges) {
        int m = edges.length;
        int[] deg = new int[n];         // stores the in-degree of a node

        for (int[] e : edges) {
            deg[e[1]]++;
        }

        int cnt = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                if (cnt > 0)
                    return -1;
                cnt++;
                ans = i;
            }
        }

        return ans;
    }
}