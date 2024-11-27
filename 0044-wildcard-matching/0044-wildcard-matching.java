class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return checkFun(s, p, 0, 0, dp);
    }
    public boolean checkFun(String s, String p, int i, int j, int[][] dp) {
        if (j == p.length())
            return i == s.length();
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {          // p can have only '*'
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != -1)
            return (dp[i][j] == 0) ? false : true;

        boolean ans = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            ans = checkFun(s, p, i+1, j+1, dp);
        else if (p.charAt(j) == '*') {
            boolean take = checkFun(s, p, i+1, j, dp);
            boolean not_take = checkFun(s, p, i, j+1, dp);
            ans = take || not_take;
        }

        dp[i][j] = (ans) ? 1 : 0;
        return ans;
    }
}