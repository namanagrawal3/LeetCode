class Solution {
    public long maxTotalValue(int[] nums, int k) {
    // Simply, find the max & min (ie, choose the whole subarray K times)
    
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];

            if (nums[i] < min)
                min = nums[i];
        }

        return 1L * (max - min) * k;
    }
}