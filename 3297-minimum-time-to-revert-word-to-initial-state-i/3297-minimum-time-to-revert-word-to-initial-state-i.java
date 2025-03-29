class Solution {
    public int minimumTimeToInitialState(String word, int k) {
    // Check at every multiple of 'k' whether remaining word is same as the prefix or not
    // thus, use the 'KMP' for finding the LPS

        int n = word.length();
        int[] dp = new int[n];
        int len = 0;
        dp[0] = 0;

        int i = 1;
        while (i < n) {
            if (word.charAt(i) == word.charAt(len)) {
                len++;
                dp[i] = len;
                i++;
            }
            else {
                if (len > 0)
                    len = dp[len - 1];
                else {
                    dp[i] = 0;
                    i++;
                }
            }
        }

        int time = 1;
        int idx = k;
        while (idx < n) {
            int remLen = n - idx;
            if (dp[n-1] >= remLen && word.indexOf(word.substring(idx)) == 0)
                break;

            idx = idx + k;
            time++;
        }

        return time;
    }
}