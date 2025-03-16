class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = Integer.MIN_VALUE;
        int[] suff = new int[n];        // stores the minimum element towards right

        suff[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suff[i] = Math.min(suff[i+1], nums[i]);
        }

        for (int i = 0; i < n-1; i++) { // partitioning at i, which is included in left
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= suff[i+1])
                return i+1;
        }
         
        return -1;
    }
}