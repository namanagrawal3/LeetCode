class Solution {
    public int rob(int[] nums) {
    // way-1 : if we rob first house then last house can't be robbed
    // way-2 : if we don't rob first house then last house can be robbed 

        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
            
        int a1 = robFun(nums, 0, n-2);
        int a2 = robFun(nums, 1, n-1);

        return Math.max(a1, a2);
    }
    public int robFun(int[] nums, int si, int ei) {
        int[] dp = new int[ei+1];
        dp[0] = (si == 0) ? nums[0] : 0;
        dp[1] = (si == 0) ? Math.max(nums[0], nums[1]) : nums[1];
        
        for (int i = 2; i <= ei; i++) {
            int rob = nums[i] + dp[i-2];
            int not_rob = dp[i-1];
            dp[i] = Math.max(rob, not_rob);
        }

        return dp[ei];
    }
}