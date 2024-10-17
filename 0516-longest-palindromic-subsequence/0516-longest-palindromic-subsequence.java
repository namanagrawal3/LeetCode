class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return solveFun(s, 0, s.length()-1, dp);
    }
    public int solveFun(String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (s.charAt(i) == s.charAt(j)) 
            ans = 2 + solveFun(s, i+1, j-1, dp);
        else {
            int first = solveFun(s, i+1, j, dp);
            int second = solveFun(s, i, j-1, dp);
            ans = Math.max(first, second);
        }

        return dp[i][j] = ans;
    }
}