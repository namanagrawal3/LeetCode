class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1)          // total sum is odd so, it can't be partitioned
            return false;

// now check whether any subset exists that sum equals 'sum/2' (Subset Sum Problem)        
        boolean[][] dp = new boolean[n+1][sum/2 +1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean take = false, not_take = false;
                if (j >= nums[i-1])
                    take = dp[i-1][j-nums[i-1]];
                not_take = dp[i-1][j];

                dp[i][j] = take || not_take;
            }
        }
        return dp[n][sum/2];
    }
}