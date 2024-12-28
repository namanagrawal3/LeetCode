class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // score --> (values[i] + i) + (values[j] - j)
        int n = values.length;
        int maxScore = Integer.MIN_VALUE;
        int maxVal = values[0];

        for (int j = 1; j < n; j++) {
            int score = maxVal + (values[j] - j);
            maxScore = Math.max(maxScore, score);
            maxVal = Math.max(maxVal, values[j]+j);
        }

        return maxScore;
    }
}