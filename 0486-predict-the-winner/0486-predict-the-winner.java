class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int[][] dp = new int[n][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        int player_1 = pointFun(nums, 0, n-1, dp);
        int player_2 = sum - player_1;

        return player_1 >= player_2;
    }
    public int pointFun(int[] nums, int si, int ei, int[][] dp) {
        if (si > ei)
            return 0;

        if (dp[si][ei] != -1)
            return dp[si][ei];

        int start = nums[si] + Math.min(pointFun(nums, si+2, ei, dp), pointFun(nums, si+1, ei-1, dp));
        int end = nums[ei] + Math.min(pointFun(nums, si+1, ei-1, dp), pointFun(nums, si, ei-2, dp));

        return dp[si][ei] = Math.max(start, end);
    }
}