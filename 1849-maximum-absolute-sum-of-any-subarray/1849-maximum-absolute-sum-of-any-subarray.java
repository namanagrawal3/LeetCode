class Solution {
    public int maxAbsoluteSum(int[] nums) {
    // We will either only increment or decrement the subarray sum, not both
    // {i.e, 3+5 = 8, (-3)+(-5) = abs(-8) = 8 but 3+(-5) = abs(-2) = 2} 
    // thus, we will find the max of maxSubarray & minSubarray sum (using Kadane's Algo)
    
        int max = maxSum(nums);
        int min = Math.abs(minSum(nums));
        return Math.max(max, min);
    }
    public int maxSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
    public int minSum(int[] arr) {
        int n = arr.length;
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            minSum = Math.min(minSum, currSum);
            if (currSum > 0)
                currSum = 0;
        }

        return minSum;
    }
}