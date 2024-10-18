class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // similar to 'longest common subsequence' problem

        int[][] dp = new int[nums1.length][nums2.length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        return lcsFun(nums1, nums2, 0, 0, dp);
    }
    public int lcsFun(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if (i == nums1.length || j == nums2.length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int count = 0;
        if (nums1[i] == nums2[j]) 
            count = 1 + lcsFun(nums1, nums2, i+1, j+1, dp);
        else {
            int first = lcsFun(nums1, nums2, i+1, j, dp);
            int second = lcsFun(nums1, nums2, i, j+1, dp);
            count = Math.max(first, second);
        }

        return dp[i][j] = count;
    }
}