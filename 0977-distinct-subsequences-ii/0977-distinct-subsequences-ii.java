class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        HashMap<Character, Integer> lastIdx = new HashMap<>();
        int mod = 1000000007;

        int[] dp = new int[n+1];
        dp[0] = 1;                  // empty subseq.

        for (int i = 1; i < dp.length; i++) {
            char ch = s.charAt(i-1);
            dp[i] = (2 * dp[i-1]) % mod;
            dp[i] %= mod;
            
            if (lastIdx.containsKey(ch))
                dp[i] = (dp[i] - dp[lastIdx.get(ch) - 1]) % mod;

            lastIdx.put(ch, i);
        }

        return (dp[n] - 1 + mod) % mod;
    }
}