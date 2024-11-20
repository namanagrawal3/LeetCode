class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];         // creating the LCS table

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder scs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                scs.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if (dp[i-1][j] >= dp[i][j-1]) {
                    scs.append(s1.charAt(i-1));
                    i--;
                }
                else {
                    scs.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while (i > 0) {
            scs.append(s1.charAt(i-1));
            i--;
        }
        while (j > 0) {
            scs.append(s2.charAt(j-1));
            j--;
        }      

        return scs.reverse().toString();
    }
}