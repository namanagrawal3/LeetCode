class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);

        return permFun(nums, target, dp);
    }
    public int permFun(int[] coins, int amount, int[] dp) {
        if (amount == 0) 
            return 1;
        
        if (dp[amount] != -1)
            return dp[amount];

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) 
                count += permFun(coins, amount-coins[i], dp);
        }

        return dp[amount] = count;
    }
}