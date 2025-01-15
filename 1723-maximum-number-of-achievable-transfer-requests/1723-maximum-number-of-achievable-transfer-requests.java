class Solution {
    int ans;
    public int maximumRequests(int n, int[][] requests) {
        int[] buld = new int[n];
        ans = 0;

        solveFun(requests, 0, buld, 0);
        return ans;
    }
    public void solveFun(int[][] req, int idx, int[] buld, int cnt) {
        if (idx == req.length) {
            boolean balance = true;
            for (int i = 0; i < buld.length; i++) {
                if (buld[i] != 0) {
                    balance = false;
                    break;
                }
            }
            if (balance)
                ans = Math.max(ans, cnt);
            return;
        }

        // ------- pick -------
        int from = req[idx][0];
        int to = req[idx][1];
        buld[from]--;
        buld[to]++;

        solveFun(req, idx+1, buld, cnt+1);

        buld[from]++;
        buld[to]--;

        // ----- not pick -----
        solveFun(req, idx+1, buld, cnt);
    }
}