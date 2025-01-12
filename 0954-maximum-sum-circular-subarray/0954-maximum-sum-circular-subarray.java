class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // ans1 --> maximum sum subarray
        int ans1 = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];
            ans1 = Math.max(ans1, curr_sum);

            if(curr_sum < 0)
                curr_sum = 0;
        }

        // ans2 --> circular maximum sum
        // circular maximum sum --> total sum - minimum sum subarray
        int min_sum = Integer.MAX_VALUE;
        int total_sum = 0;
        curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];
            min_sum = Math.min(min_sum, curr_sum);

            if (curr_sum > 0)
                curr_sum = 0;

            total_sum += nums[i];
        }
        int ans2 = total_sum - min_sum;

        if (ans1 > 0)
            return Math.max(ans1, ans2);
        return ans1;
    }
}