class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // similar to 'longest common subsequence' problem

        int[][] dp = new int[nums1.length+1][nums2.length+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    int one = dp[i-1][j];
                    int two = dp[i][j-1];
                    dp[i][j] = Math.max(one, two);
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}