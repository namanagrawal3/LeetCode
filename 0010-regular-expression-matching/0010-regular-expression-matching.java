class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return checkFun(s, p, 0, 0, dp);
    }
    public boolean checkFun(String s, String p, int i, int j, int[][] dp) {
        if (j == p.length())
            return i == s.length();

        if (dp[i][j] != -1)
            return (dp[i][j] == 0) ? false : true;

        boolean firstChar = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) ? true : false;

        if (j < p.length()-1 && p.charAt(j+1) == '*') {
            boolean take = firstChar && checkFun(s, p, i+1, j, dp);
            boolean not_take = checkFun(s, p, i, j+2, dp);

            dp[i][j] = (take || not_take) ? 1 : 0;
            return take || not_take;
        }
        
        boolean ans = firstChar && checkFun(s, p, i+1, j+1, dp);
        dp[i][j] = (ans) ? 1 : 0;
        return ans;
    }
}