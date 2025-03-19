class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int mask = 0;
        int si = 0, ei = 0;

        while (ei < n) {
            while ((mask & nums[ei]) != 0 && si <= ei) {
                mask = mask ^ nums[si]; // Way to shrink the window (in bitmanipulation)
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1); 
            mask = mask | nums[ei];    // Used to check the bitwise AND of all pairs is 0
            ei++;
        }

        return maxLen;
    }
}