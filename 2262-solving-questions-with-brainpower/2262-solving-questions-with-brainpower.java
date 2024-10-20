class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);

        return solveFun(questions, 0, dp);
    }
    public static long solveFun(int[][] que, int idx, long[] dp) {
        if (idx >= que.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        long solve = que[idx][0] + solveFun(que, idx + que[idx][1] + 1, dp);
        long skip = solveFun(que, idx + 1, dp);

        return dp[idx] = Math.max(solve, skip);
    }
}