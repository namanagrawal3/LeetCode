class Solution {
    int mod = 1000000007;
    public int colorTheGrid(int m, int n) {
    // Since, m << n, ie, there are less no. of rows than columns

        // Step-1 Generating all the possible column-states
        List<String> l = new ArrayList<>();     
        stateFun(m, "",'*', l);

        // Step-2 Checking all possible combinations of states
        int[][] dp = new int[l.size()][n];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }

        int cnt = 0;
        for (int i = 0; i < l.size(); i++) {
            cnt = (cnt + countFun(l, i, n-1, dp)) % mod;
        }

        return cnt;
    }
    public void stateFun(int rows, String currState, char prevColor, List<String> l) {
        if (currState.length() == rows) {
            l.add(currState);
            return;
        }

        char[] colors = {'R', 'G', 'B'};

        for (char color: colors) {
            if (prevColor == color)
                continue;
            stateFun(rows, currState + color, color, l);
        }
    }
    public int countFun(List<String> l, int prevStateIdx, int leftCols, int[][] dp) {
        if (leftCols == 0)
            return 1;
        if (dp[prevStateIdx][leftCols] != -1)
            return dp[prevStateIdx][leftCols];

        String prevState = l.get(prevStateIdx);
        int cnt = 0;
        for (int i = 0; i < l.size(); i++) {
            if (i == prevStateIdx || !checkValidity(prevState, l.get(i)))
                continue;
            cnt = (cnt + countFun(l, i, leftCols-1, dp)) % mod;
        }

        return dp[prevStateIdx][leftCols] = cnt;
    }
    public boolean checkValidity(String prevState, String currState) {
        int n = prevState.length();

        for (int i = 0; i < n; i++) {
            if (prevState.charAt(i) == currState.charAt(i))
                return false;
        }

        return true;
    }
}