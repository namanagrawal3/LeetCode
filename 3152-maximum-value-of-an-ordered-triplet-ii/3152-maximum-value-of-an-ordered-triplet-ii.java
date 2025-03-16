class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];        // stores the max element towards right

        suff[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suff[i] = Math.max(suff[i+1], nums[i]);
        }

        int leftMax = nums[0];
        long ans = 0;

        for (int i = 1; i < n-1; i++) { 
            long val = 1L * (leftMax - nums[i]) * suff[i+1];
            ans = Math.max(ans, val);
            leftMax = Math.max(leftMax, nums[i]);
        }
         
        return ans;
    }
}