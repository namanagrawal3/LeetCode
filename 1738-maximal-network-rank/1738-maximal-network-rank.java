class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int rank = adj.get(i).size() + adj.get(j).size();
                if (adj.get(i).contains(j))
                    rank--;

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}