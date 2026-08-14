class Solution {
    public int minimumAverageDifference(int[] nums) {
    // Approach 1: Use the 'Prefix-Sum' technique to find the average efficiently
    // Approach 2: Use the 'totalSum' & 'currSum' variables

        int n = nums.length;
        long totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        long currSum = 0;
        int minIdx = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i];
            currSum += nums[i];
            long avg1 = currSum / (i+1);
            long avg2 = (i < n-1) ? totalSum / (n-1-i) : 0;

            int diff = (int) Math.abs(avg1 - avg2);
            if (diff < minDiff) {
                minDiff = diff;
                minIdx = i;
            } 
        } 

        return minIdx;
    }
}