class Solution {
    public int maxEnvelopes(int[][] env) {
        int n = env.length;
        Arrays.sort(env, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])          // if width is same, then sort descending height-wise
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        // now, find the length of the LIS according to height
        int[] dp = new int[n];
        dp[0] = env[0][1];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (env[i][1] > dp[len-1]) {
                dp[len] = env[i][1];
                len++;
            }
            else {
                int idx = binarySearch(dp, 0, len-1, env[i][1]);
                dp[idx] = env[i][1];
            }
        }
        return len;
    }
    public int binarySearch(int[] dp, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si + (ei-si)/2;

            if (dp[mid] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
}