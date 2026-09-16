class Solution {
    boolean[][] isPalindrome;

    public int maxPalindromes(String s, int k) {
    // Simply try all possibilities using recursion then memoise it
    // Also, use the efficient way to find the 'isPalindrome'

        int n = s.length();
        if (k == 1)
            return n;
        
        isPalindrome = new boolean[n+1][n+1];
        findAllPalindromes(s, n, isPalindrome);

        int[][] dp = new int[n+1][n+1];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }
        return solveFun(s, 0, k-1, k, dp);
    }
    public void findAllPalindromes(String s, int n, boolean[][] isPalindrome) {
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i+len <= n; i++) {
                int j = i + len - 1;

                if (len == 1)
                    isPalindrome[i][j] = true;
                else if (len == 2)
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                else 
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1];
            }
        }
    }
    public int solveFun(String s, int i, int j, int k, int[][] dp) {
        if (j >= s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (isPalindrome[i][j]) {
            int take = 1 + solveFun(s, j+1, j+k, k, dp);
            int grow = solveFun(s, i, j+1, k, dp);
            int slide = solveFun(s, i+1, j+1, k, dp);
            return dp[i][j] = Math.max(take, Math.max(grow, slide));
        }

        int grow = solveFun(s, i, j+1, k, dp);
        int slide = solveFun(s, i+1, j+1, k, dp);
        return dp[i][j] = Math.max(grow, slide);
    }
}