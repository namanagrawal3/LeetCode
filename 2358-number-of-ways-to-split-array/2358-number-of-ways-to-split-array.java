class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int cnt = 0;
        long curr = 0;
        for (int i = 0; i < n-1; i++) {
            curr += nums[i];
            sum -= nums[i];
            if (curr >= sum)
                cnt++;
        }

        return cnt;
    }
}