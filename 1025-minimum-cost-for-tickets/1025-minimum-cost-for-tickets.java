class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return costFun(days, costs, 0, dp);
    }
    public int costFun(int[] days, int[] costs, int idx, int[] dp) {
        if (idx >= days.length)
            return 0;

        if (dp[idx] != 0)
            return dp[idx];

        int day1 = costs[0] + costFun(days, costs, idx+1, dp);
        int day7 = costs[1] + costFun(days, costs, idxFun(idx, days, 7), dp);
        int day30 = costs[2] + costFun(days, costs, idxFun(idx, days, 30), dp);

        return dp[idx] = Math.min(day1, Math.min(day7, day30));
    }
    public int idxFun(int idx, int[] days, int d) {
        int target = days[idx] + d-1;
        int si = idx, ei = days.length-1;

        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (days[mid] <= target)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return ei+1;
    }
}