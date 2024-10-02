class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solveFun(s, 0, n, dp);
    }
    public int solveFun(String s, int idx, int n, int[] dp) {
        if (idx == n)
            return 1;

        if (dp[idx] != -1)
            return dp[idx];

        if (s.charAt(idx) == '0')
            return 0;

        int cnt = 0;
        for (int i = idx; i < n; i++) {
            String temp = s.substring(idx, i+1);
            if (temp.length() <= 2 && Integer.parseInt(temp) <= 26) 
                cnt += solveFun(s, i+1, n, dp);
            else
                break;
        }

        return dp[idx] = cnt;
    }
}