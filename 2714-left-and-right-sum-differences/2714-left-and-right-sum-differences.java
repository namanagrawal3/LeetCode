class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        
        int[] ans = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            ans[i] = Math.abs(sum - curr);
            curr += nums[i];
        }

        return ans;
    }
}