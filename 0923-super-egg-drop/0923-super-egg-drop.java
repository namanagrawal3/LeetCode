class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];     // Egg Drop Problem (MCM with Binary Search)
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return trialFun1(k, n, dp);
    }
    public int trialFun1(int eggs, int floors, int[][] dp) {
        if (floors == 0 || floors == 1)
            return floors;
        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int minTrials = Integer.MAX_VALUE;
        int si = 1, ei = floors;
        while (si <= ei) {
            int mid = si + (ei-si)/2;

            int breaks = trialFun1(eggs-1, mid-1, dp);          // going left (downwards)
            int not_break = trialFun1(eggs, floors-mid, dp);    // going right (topwards)
            int trials = 1 + Math.max(breaks, not_break);
            minTrials = Math.min(minTrials, trials);

            if (breaks < not_break)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return dp[eggs][floors] = minTrials;
    }
}