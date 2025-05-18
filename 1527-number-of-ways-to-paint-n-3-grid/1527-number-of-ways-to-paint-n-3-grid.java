class Solution {
    int mod = 1000000007;
    public int numOfWays(int n) {
    // Since, there are only 3 columns. Thus, consider the row-states

        // Step-1 Generating all the possible row-states
        List<String> l = new ArrayList<>();     
        stateFun(3, "",'*', l);

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
    public void stateFun(int cols, String currState, char prevColor, List<String> l) {
        if (currState.length() == cols) {
            l.add(currState);
            return;
        }

        char[] colors = {'R', 'G', 'B'};

        for (char color: colors) {
            if (color == prevColor)
                continue;
            stateFun(cols, currState + color, color, l);
        }
    }
    public int countFun(List<String> l, int prevStateIdx, int leftRows, int[][] dp) {
        if (leftRows == 0)
            return 1;
        if (dp[prevStateIdx][leftRows] != -1)
            return dp[prevStateIdx][leftRows];

        String prevState = l.get(prevStateIdx);
        int cnt = 0;
        for (int i = 0; i < l.size(); i++) {
            if (i == prevStateIdx || !checkValidity(prevState, l.get(i)))
                continue;
            cnt = (cnt + countFun(l, i, leftRows-1, dp)) % mod;
        }

        return dp[prevStateIdx][leftRows] = cnt;
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