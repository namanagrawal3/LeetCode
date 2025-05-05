class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];

        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edges[i];
            score[v] += i;
        }

        long maxScore = Long.MIN_VALUE;
        int maxNode = -1;
        for (int i = n-1; i >= 0; i--) {
            if (score[i] >= maxScore) {
                maxScore = score[i];
                maxNode = i;
            }
        }

        return maxNode;
    }
}