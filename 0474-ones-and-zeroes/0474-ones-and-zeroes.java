class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];

        return solveFun(strs, 0, m, n, dp);
    }
    public static int solveFun(String[] arr, int i, int zeros, int ones, int[][][] dp) {
        if (i >= arr.length)
            return 0;

        if (dp[i][zeros][ones] != 0)
            return dp[i][zeros][ones];

        int notTake = solveFun(arr, i+1, zeros, ones, dp);
        int take = 0;

        int m = zeroFun(arr[i]);
        int n = arr[i].length() - m;
        if (zeros >= m && ones >= n)
            take = 1 + solveFun(arr, i+1, zeros-m, ones-n, dp);

        return dp[i][zeros][ones] = Math.max(take, notTake);
    }
    public static int zeroFun(String s) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                cnt++;
        }
        return cnt;
    }
}