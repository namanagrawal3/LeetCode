class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];          // dp[i] -> length of LIS ending at nums[i]
        int[] cnt = new int[n];         // cnt[i] -> count of LIS upto i index

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                    else if (dp[j] + 1 == dp[i])
                        cnt[i] += cnt[j];
                }
            }
        }

        int maxLen = Arrays.stream(dp).max().getAsInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen)
                count += cnt[i];
        }

        return count;

    }
}