class Solution {
    public int longestStrChain(String[] words) {
    // Variant of 'LIS' Problem 
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }
    public boolean isPredecessor(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (n - m != 1)
            return false;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j))
                i++;
            j++;
        }

        return i == m;
    }
}