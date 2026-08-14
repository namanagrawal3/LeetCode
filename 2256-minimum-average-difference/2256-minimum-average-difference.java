class Solution {
    public int minimumAverageDifference(int[] nums) {
    // Simply use the 'Prefix-Sum' technique to find the average efficiently

        int n = nums.length;
        long[] preSum = new long[n];
        
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }

        int minIdx = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long avg1 = preSum[i] / (i+1);
            long avg2 = (i < n-1) ? (preSum[n-1] - preSum[i]) / (n-1-i) : 0;

            int diff = (int) Math.abs(avg1 - avg2);
            if (diff < minDiff) {
                minDiff = diff;
                minIdx = i;
            } 
        } 

        return minIdx;
    }
}