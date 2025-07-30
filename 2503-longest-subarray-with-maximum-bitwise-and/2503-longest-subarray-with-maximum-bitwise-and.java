class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];          // finding the max value
        for (int i = 1; i < n; i++) {
            if (nums[i] > maxVal)
                maxVal = nums[i];
        }

        int maxLen = 1;
        int count = 0;                // finding the longest subarray of max value
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxVal)
                count++;
            else {
                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }
        maxLen = Math.max(maxLen, count);

        return maxLen;
    }
}