class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        rightMax[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        int leftMin = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < n; i++) {
            if (leftMin < rightMax[i])
                maxDiff = Math.max(maxDiff, rightMax[i] - leftMin);
            
            leftMin = Math.min(leftMin, nums[i]);
        }

        return maxDiff;
    }
}