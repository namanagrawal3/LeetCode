class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];        // stores the minimum element towards it's right

        suff[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suff[i] = Math.min(suff[i+1], nums[i]);
        }

        int leftMax = nums[0];
        int ans = 0;

        for (int i = 1; i < n-1; i++) {
            if (nums[i] > leftMax && nums[i] < suff[i+1])
                ans += 2;
            else if (nums[i] > nums[i-1] && nums[i] < nums[i+1])
                ans += 1; 
            else
                ans += 0;

            leftMax = Math.max(leftMax, nums[i]);
        }
         
        return ans;
    }
}