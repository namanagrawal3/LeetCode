class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int offset = Math.abs(target-sum);

        int[][] dp = new int[nums.length][target+sum+offset +1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return countFun(nums, 0, target, dp, offset);
    }
    public static int countFun(int[] arr, int idx, int sum, int[][] dp, int offset) {
        if (idx == arr.length)
            return (sum == 0) ? 1 : 0;

        if (dp[idx][sum+offset] != -1)
            return dp[idx][sum+offset];
            
        int plus = countFun(arr, idx+1, sum-arr[idx], dp, offset);
        int minus = countFun(arr, idx+1, sum+arr[idx], dp, offset);
        
        return dp[idx][sum+offset] = plus+minus;
    }
}