class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        for (String str : dictionary) {
            set.add(str);
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solveFun(s, 0, n, set, dp);
    }
    public static int solveFun(String s, int i, int n, HashSet<String> set, int[] dp) {
        if (i >= n)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int result = 1 + solveFun(s, i+1, n, set, dp);// taking s[i] as extra char

        for (int j = i; j < n; j++) {                 // taking s[i] as word char
            String temp = s.substring(i, j+1);
            if (set.contains(temp))
                result = Math.min(result, solveFun(s, j+1, n, set, dp));
        }

        return dp[i] = result;
    }
}