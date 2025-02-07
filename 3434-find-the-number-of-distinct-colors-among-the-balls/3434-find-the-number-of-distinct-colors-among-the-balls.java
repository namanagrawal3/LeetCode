class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> ballColors = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int idx = 0;

        for (int[] query : queries) {
            int ball = query[0];
            int color = query[1];

            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            ballColors.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);

            ans[idx++] = colorCount.size();
        }

        return ans;
    }
}