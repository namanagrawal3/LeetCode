class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = nums[n-1];
        int prev = nums[n-1];

        for (int i = n-2; i >= 0; i--) {
            if (nums[i] <= 0)
                return sum;
            else if (nums[i] != prev)
                sum += nums[i];

            prev = nums[i];
        }

        return sum;
    }
}