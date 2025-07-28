class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        long[] dp = new long[rides.length];
        return maxEarning(rides, 0, dp);
    }
    public long maxEarning(int[][] rides, int idx, long[] dp) {
        if (idx == rides.length)
            return 0;

        if (dp[idx] != 0)
            return dp[idx];

        long take = (rides[idx][1] - rides[idx][0] + rides[idx][2]) + maxEarning(rides, binFun(rides, rides[idx][1]), dp);
        long not_take = maxEarning(rides, idx+1, dp);

        return dp[idx] = Math.max(take, not_take);
    }
    public int binFun(int[][] rides, int target) {
        int si = 0;
        int ei = rides.length-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (rides[mid][0] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
}