class Solution {
    public long getDescentPeriods(int[] prices) {
    // Simply, use the variable length sliding-window
        int n = prices.length;
        int si = 0, ei = 1;
        long cnt = 1;

        while (ei < n) {
            if (prices[ei-1] - prices[ei] != 1)
                si = ei;

            cnt += (ei-si+1);
            ei++;
        }

        return cnt;
    }
}