class Solution {
    public boolean increasingTriplet(int[] nums) {
        // simply check whether the length of LIS >= 3
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len-1]) {
                dp[len] = nums[i];
                len++;
            }
            else {
                int idx = binSearch(dp, 0, len-1, nums[i]);
                dp[idx] = nums[i];
            }
        }

        return len >= 3;
    }
    public int binSearch(int[] dp, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (dp[mid] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;        
    }
}