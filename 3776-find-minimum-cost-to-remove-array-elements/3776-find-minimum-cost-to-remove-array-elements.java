class Solution {
    public int minCost(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
    
        return minFun(nums, 0, 1, dp);
    }
    public int minFun(int[] nums, int prev, int idx, int[][] dp) {
        // one element left
        if (idx == nums.length)
            return nums[prev];
        
        // two elements left
        if (idx == nums.length-1)
            return Math.max(nums[prev], nums[idx]);

        if (dp[prev][idx] != 0)
            return dp[prev][idx];
        
        // a, b, c
        int one = Math.max(nums[idx], nums[idx+1]) + minFun(nums, prev, idx+2, dp);  // b, c
        int two = Math.max(nums[prev], nums[idx]) + minFun(nums, idx+1, idx+2, dp);  // a, b
        int three = Math.max(nums[prev], nums[idx+1]) + minFun(nums, idx, idx+2, dp);// a, c

        return dp[prev][idx] = Math.min(one, Math.min(two, three));
    }
}