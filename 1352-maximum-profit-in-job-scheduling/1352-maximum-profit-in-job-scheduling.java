class Solution {
    class Pair {
        int st;     // startTime
        int et;     // endTime
        int pr;     // Profit
        public Pair(int s, int e, int p) {
            st = s;
            et = e;
            pr = p;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Pair[] jobs = new Pair[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Pair(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.st - b.st;
            }
        });

        int[] dp = new int[n];
        return maxProfit(jobs, 0, dp);
    }
    public int maxProfit(Pair[] jobs, int idx, int[] dp) {
        if (idx == jobs.length)
            return 0;

        if (dp[idx] != 0)
            return dp[idx];

        int take = jobs[idx].pr + maxProfit(jobs, binFun(jobs, jobs[idx].et), dp);
        int not_take = maxProfit(jobs, idx+1, dp);

        return dp[idx] = Math.max(take, not_take);
    }
    public int binFun(Pair[] jobs, int target) {
        int si = 0;
        int ei = jobs.length-1;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (jobs[mid].st >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
}