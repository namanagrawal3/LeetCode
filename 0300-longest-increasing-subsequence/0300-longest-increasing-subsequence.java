class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        return lisFun(nums, n, 0, -1, dp);        
    }
    public int lisFun(int[] nums, int n, int currIdx, int prevIdx, int[][] dp) {
        if (currIdx == n)
            return 0;

        if (dp[currIdx][prevIdx+1] != 0)
            return dp[currIdx][prevIdx+1];

        int take = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx])
            take = 1 + lisFun(nums, n, currIdx + 1, currIdx, dp);
        
        int not_take = lisFun(nums, n, currIdx + 1, prevIdx, dp);

        return dp[currIdx][prevIdx+1] = Math.max(take, not_take);
    }
}