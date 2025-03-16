class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];        // stores the min element towards right

        suff[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suff[i] = Math.min(suff[i+1], nums[i]);
        }

        int leftMin = nums[0];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n-1; i++) { 
            if (nums[i] > leftMin && nums[i] > suff[i+1]) {
                int val = leftMin + nums[i] + suff[i+1];
                ans = Math.min(ans, val);
            }

            leftMin = Math.min(leftMin, nums[i]);
        }
         
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}