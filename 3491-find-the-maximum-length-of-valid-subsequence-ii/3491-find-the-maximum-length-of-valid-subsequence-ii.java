class Solution {
    public int maximumLength(int[] nums, int k) {
    // Similar variant of LIS (Longest Subsequence)  -->  Bottom-Up approach

        int n = nums.length;
        int maxLen = 1;

        int[][] dp = new int[k][n];
        for (int[] r: dp) {
            Arrays.fill(r, 1);
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int rem = (nums[i] + nums[j]) % k;
                dp[rem][i] = Math.max(dp[rem][i], dp[rem][j] + 1);

                maxLen = Math.max(maxLen, dp[rem][i]);
            }
        }
        
        return maxLen;
    }
}