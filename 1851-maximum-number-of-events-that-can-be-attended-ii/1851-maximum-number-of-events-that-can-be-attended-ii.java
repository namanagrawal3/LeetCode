class Solution {
    public int maxValue(int[][] events, int k) {
        // sort on the basis of start-point
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        // check all the possibilities using recursion
        int[][] dp = new int[events.length][k+1];
        return maxValueFun(events, 0, k, dp);
    }
    public int maxValueFun(int[][] events, int idx, int k, int[][] dp) {
        if (idx == events.length || k == 0)
            return 0;

        if (dp[idx][k] != 0)
            return dp[idx][k];

        int take = events[idx][2] + maxValueFun(events, binFun(events, idx+1, events[idx][1]), k-1, dp);
        int not_take = maxValueFun(events, idx+1, k, dp);

        return dp[idx][k] = Math.max(take, not_take);
    }
    public int binFun(int[][] events, int si, int target) {
        int ei = events.length-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (events[mid][0] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
}